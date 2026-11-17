package com.rpgclicker.domain.usecase

import com.rpgclicker.data.repository.GameRepository
import com.rpgclicker.domain.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class GameEngine(
    private val repository: GameRepository
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var autoBattleJob: Job? = null

    // Evita corrida de leitura/escrita entre toque e auto-ataque
    private val mutex = Mutex()

    /** Garante dados iniciais (seed) e um inimigo ativo. */
    suspend fun ensureInitialState() = mutex.withLock {
        repository.seedIfNeeded()
        val state = repository.loadGameState()
        if (state.currentEnemy == null) {
            val enemy = firstEnemyOf(state.currentAreaId)
            repository.saveGameState(state.copy(currentEnemy = enemy))
        }
    }

    suspend fun onTapAttack(): AttackResult = mutex.withLock {
        val state = repository.loadGameState()
        val hero = state.hero
        val isCrit = kotlin.random.Random.nextDouble() < hero.critChance
        val damage = if (isCrit) (hero.clickPower * hero.critDamageMultiplier).toInt() else hero.clickPower.toInt()
        val (newState, result) = applyDamage(state, kotlin.math.max(damage, 1), isCrit, isClick = true)
        if (result.success) repository.saveGameState(newState)
        result
    }

    /** Ataque automatico: dano = autoDps por segundo. */
    private suspend fun onAutoAttack() = mutex.withLock {
        val state = repository.loadGameState()
        val damage = state.hero.autoDps.toInt()
        if (damage <= 0 || state.currentEnemy == null) return@withLock
        val (newState, result) = applyDamage(state, damage, isCrit = false, isClick = false)
        if (result.success) repository.saveGameState(newState)
    }

    private suspend fun applyDamage(
        state: GameState,
        damage: Int,
        isCrit: Boolean,
        isClick: Boolean
    ): Pair<GameState, AttackResult> {
        val enemy = state.currentEnemy
            ?: return state to AttackResult(false, "Nenhum inimigo", 0, 0, 0, false, false, null)

        val newHealth = kotlin.math.max(enemy.currentHealth - damage, 0)
        val defeated = newHealth <= 0

        val clicks = state.statistics.totalClicks + if (isClick) 1 else 0

        if (!defeated) {
            val newEnemy = enemy.withHealth(newHealth)
            val newState = state.copy(
                currentEnemy = newEnemy,
                statistics = state.statistics.copy(totalClicks = clicks)
            )
            return newState to AttackResult(true, "Ataque!", damage, 0, 0, false, isCrit, newEnemy)
        }

        // Inimigo derrotado: recompensas
        val prestigeBonus = 1.0 + 0.1 * state.prestige.globalMultiplier
        val goldEarned = (enemy.goldReward * state.hero.goldMultiplier * prestigeBonus).toInt()
        val expEarned = enemy.expReward

        val leveled = addExperience(state.hero.copy(gold = state.hero.gold + goldEarned), expEarned)

        val unlocked = state.unlockedAreas.toMutableSet()
        val areas = repository.getAllAreas()
        areas.filter { it.unlockRequirement <= leveled.level }.forEach { unlocked.add(it.id) }

        // Proximo inimigo (ou proxima area, se ja liberada)
        val (nextEnemy, nextAreaId) = nextEnemyAfter(state.currentAreaId, enemy.id, areas, unlocked)

        val newState = state.copy(
            currentEnemy = nextEnemy,
            currentAreaId = nextAreaId,
            unlockedAreas = unlocked,
            hero = leveled,
            statistics = state.statistics.copy(
                totalClicks = clicks,
                totalGoldEarned = state.statistics.totalGoldEarned + goldEarned,
                enemiesDefeated = state.statistics.enemiesDefeated + 1,
                highestLevelReached = kotlin.math.max(state.statistics.highestLevelReached, leveled.level),
                highestAreaReached = highestArea(state.statistics.highestAreaReached, nextAreaId, areas)
            )
        )
        return newState to AttackResult(true, "Inimigo derrotado!", damage, goldEarned, expEarned, true, isCrit, nextEnemy)
    }

    private fun highestArea(current: String, candidate: String, areas: List<Area>): String {
        val cur = areas.firstOrNull { it.id == current }?.order ?: 0
        val cand = areas.firstOrNull { it.id == candidate }?.order ?: 0
        return if (cand > cur) candidate else current
    }

    private suspend fun firstEnemyOf(areaId: String): Enemy? {
        val area = repository.getArea(areaId) ?: return null
        val id = area.enemyIds.firstOrNull() ?: return null
        return repository.getEnemy(id)?.fresh()
    }

    private suspend fun nextEnemyAfter(
        areaId: String,
        defeatedId: String,
        areas: List<Area>,
        unlocked: Set<String>
    ): Pair<Enemy?, String> {
        val area = areas.firstOrNull { it.id == areaId } ?: return null to areaId
        val index = area.enemyIds.indexOf(defeatedId)

        // Ainda ha inimigos nesta area
        if (index >= 0 && index + 1 < area.enemyIds.size) {
            return repository.getEnemy(area.enemyIds[index + 1])?.fresh() to areaId
        }

        // Fim da area: avanca para a proxima liberada, senao repete a atual
        val nextArea = areas.firstOrNull { it.order > area.order && it.id in unlocked }
        val target = nextArea ?: area
        val firstId = target.enemyIds.firstOrNull() ?: return null to areaId
        return repository.getEnemy(firstId)?.fresh() to target.id
    }

    /** Aplica XP e sobe de nivel quantas vezes for preciso. */
    private fun addExperience(hero: Hero, exp: Int): Hero {
        var h = hero.copy(experience = hero.experience + exp)
        while (h.experience >= h.experienceToNextLevel) {
            h = h.copy(
                level = h.level + 1,
                experience = h.experience - h.experienceToNextLevel,
                experienceToNextLevel = (h.experienceToNextLevel * 1.5).toInt(),
                maxHealth = h.maxHealth + 10,
                currentHealth = h.maxHealth + 10
            )
        }
        return h
    }

    suspend fun purchaseUpgrade(upgradeId: String): PurchaseResult = mutex.withLock {
        val state = repository.loadGameState()
        val upgrade = repository.getUpgrade(upgradeId)
            ?: return@withLock PurchaseResult(false, "Upgrade nao encontrado", 0)

        val currentLevel = state.purchasedUpgrades[upgradeId] ?: 0
        if (currentLevel >= upgrade.maxLevel) return@withLock PurchaseResult(false, "Nivel maximo", currentLevel)

        // Verificar pre-requisito
        if (upgrade.prerequisiteId != null) {
            val prereqLevel = state.purchasedUpgrades[upgrade.prerequisiteId] ?: 0
            if (prereqLevel == 0) return@withLock PurchaseResult(false, "Pre-requisito nao atendido", currentLevel)
        }

        val cost = upgrade.currentCost(currentLevel)
        if (state.hero.gold < cost) return@withLock PurchaseResult(false, "Ouro insuficiente", currentLevel)

        val value = upgrade.currentValue(currentLevel)
        var hero = state.hero.copy(gold = state.hero.gold - cost)

        // Aplicar efeitos do upgrade
        hero = when (upgrade.type) {
            Upgrade.UpgradeType.CLICK_POWER -> hero.copy(clickPower = hero.clickPower + value)
            Upgrade.UpgradeType.AUTO_DPS -> hero.copy(autoDps = hero.autoDps + value)
            Upgrade.UpgradeType.GOLD_MULTIPLIER -> hero.copy(goldMultiplier = hero.goldMultiplier + value)
            Upgrade.UpgradeType.HEALTH -> hero.copy(
                maxHealth = hero.maxHealth + value.toInt(),
                currentHealth = hero.currentHealth + value.toInt()
            )
            Upgrade.UpgradeType.CRIT_CHANCE -> hero.copy(critChance = kotlin.math.min(hero.critChance + value, 1.0))
            Upgrade.UpgradeType.CRIT_DAMAGE -> hero.copy(critDamageMultiplier = hero.critDamageMultiplier + value)
        }

        val newState = state.copy(
            hero = hero,
            purchasedUpgrades = state.purchasedUpgrades + (upgradeId to (currentLevel + 1)),
            statistics = state.statistics.copy(totalGoldSpent = state.statistics.totalGoldSpent + cost)
        )
        repository.saveGameState(newState)
        PurchaseResult(true, "Upgrade comprado", currentLevel + 1)
    }

    suspend fun doPrestige(): PrestigeResult = mutex.withLock {
        val state = repository.loadGameState()
        if (!state.canPrestige()) return@withLock PrestigeResult(false, 0, state.prestige.crystals)

        val crystals = state.crystalsOnPrestige()
        val newPrestige = state.prestige.copy(
            crystals = state.prestige.crystals + crystals,
            totalCrystalsEarned = state.prestige.totalCrystalsEarned + crystals,
            globalMultiplier = state.prestige.globalMultiplier + 1,
            prestigeCount = state.prestige.prestigeCount + 1,
            bestRunGold = kotlin.math.max(state.prestige.bestRunGold, state.hero.gold)
        )

        val newState = state.copy(
            hero = Hero(),
            currentEnemy = firstEnemyOf("area_01"),
            currentAreaId = "area_01",
            unlockedAreas = setOf("area_01"),
            purchasedUpgrades = emptyMap(),
            prestige = newPrestige,
            statistics = state.statistics.copy(timesPrestiged = state.statistics.timesPrestiged + 1)
        )
        repository.saveGameState(newState)
        PrestigeResult(success = true, crystalsEarned = crystals, newCrystals = newPrestige.crystals)
    }

    fun calculateOfflineProgress(state: GameState): OfflineProgress {
        val now = Clock.System.now()
        val minutesElapsed = (now.toEpochMilliseconds() - state.lastSaved.toEpochMilliseconds()) / (1000 * 60)
        if (minutesElapsed <= 0) return OfflineProgress(0, 0)

        val capped = kotlin.math.min(minutesElapsed, MAX_OFFLINE_MINUTES)
        val goldEarned = (state.hero.autoDps * capped).toLong()
        val expEarned = (capped * 10).toInt()
        return OfflineProgress(goldEarned, expEarned)
    }

    /** Calcula e aplica o progresso offline; devolve o que foi ganho. */
    suspend fun applyOfflineProgress(): OfflineProgress = mutex.withLock {
        val state = repository.loadGameState()
        val progress = calculateOfflineProgress(state)
        if (progress.gold > 0 || progress.exp > 0) {
            val hero = addExperience(state.hero.copy(gold = state.hero.gold + progress.gold), progress.exp)
            repository.saveGameState(
                state.copy(
                    hero = hero,
                    lastSaved = Clock.System.now(),
                    statistics = state.statistics.copy(
                        totalGoldEarned = state.statistics.totalGoldEarned + progress.gold,
                        highestLevelReached = kotlin.math.max(state.statistics.highestLevelReached, hero.level)
                    )
                )
            )
        }
        progress
    }

    fun startAutoBattle() {
        autoBattleJob?.cancel()
        autoBattleJob = scope.launch {
            while (isActive) {
                delay(1000)
                onAutoAttack()
            }
        }
    }

    fun stopAutoBattle() {
        autoBattleJob?.cancel()
        autoBattleJob = null
    }

    companion object {
        private const val MAX_OFFLINE_MINUTES = 480L // limite de 8h
    }
}

data class AttackResult(
    val success: Boolean,
    val message: String,
    val damage: Int,
    val goldEarned: Int,
    val expEarned: Int,
    val enemyDefeated: Boolean,
    val isCritical: Boolean,
    val enemy: Enemy?
)

data class PurchaseResult(
    val success: Boolean,
    val message: String,
    val newLevel: Int
)

data class PrestigeResult(
    val success: Boolean,
    val crystalsEarned: Int,
    val newCrystals: Int
)

data class OfflineProgress(
    val gold: Long,
    val exp: Int
)
