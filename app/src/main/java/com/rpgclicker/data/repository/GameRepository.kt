package com.rpgclicker.data.repository

import android.content.Context
import com.rpgclicker.data.local.GameDatabase
import com.rpgclicker.data.local.GameStateEntity
import com.rpgclicker.data.local.toDomain
import com.rpgclicker.data.local.toEntity
import com.rpgclicker.domain.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class GameRepository(
    private val database: GameDatabase,
    private val context: Context
) {
    private val dao = database.gameDao()
    private val json = Json { ignoreUnknownKeys = true; encodeDefaults = true }

    // Seed: carrega enemies.json / areas.json / upgrades.json (assets) na primeira execucao
    suspend fun seedIfNeeded() {
        if (dao.getAllAreas().isNotEmpty()) return
        val enemies: List<Enemy> = json.decodeFromString(readAsset("enemies.json"))
        val areas: List<Area> = json.decodeFromString(readAsset("areas.json"))
        val upgrades: List<Upgrade> = json.decodeFromString(readAsset("upgrades.json"))
        saveEnemies(enemies)
        saveAreas(areas)
        saveUpgrades(upgrades)
    }

    private fun readAsset(name: String): String =
        context.assets.open(name).bufferedReader().use { it.readText() }

    // Game State
    fun observeGameState(): Flow<GameState> = dao.getGameState()
        .map { entity -> if (entity == null) GameState() else deserializeGameState(entity) }

    suspend fun saveGameState(state: GameState) {
        dao.insertGameState(serializeGameState(state))
    }

    /** Estado salvo, ou um estado novo se nada foi salvo ainda. */
    suspend fun loadGameState(): GameState =
        dao.getGameStateOnce()?.let { deserializeGameState(it) } ?: GameState()

    // Enemies
    suspend fun getEnemy(id: String): Enemy? = dao.getEnemy(id)?.toDomain()
    suspend fun getEnemiesByArea(areaId: String): List<Enemy> =
        dao.getEnemiesByArea(areaId).map { it.toDomain() }
    suspend fun saveEnemies(enemies: List<Enemy>) {
        dao.insertEnemies(enemies.map { it.toEntity() })
    }

    // Areas
    suspend fun getArea(id: String): Area? = dao.getArea(id)?.toDomain()
    suspend fun getAllAreas(): List<Area> = dao.getAllAreas().map { it.toDomain() }
    suspend fun saveAreas(areas: List<Area>) {
        dao.insertAreas(areas.map { it.toEntity() })
    }

    // Upgrades
    suspend fun getUpgrade(id: String): Upgrade? = dao.getUpgrade(id)?.toDomain()
    suspend fun getAllUpgrades(): List<Upgrade> = dao.getAllUpgrades().map { it.toDomain() }
    suspend fun saveUpgrades(upgrades: List<Upgrade>) {
        dao.insertUpgrades(upgrades.map { it.toEntity() })
    }

    fun getAllUpgradesFlow(): Flow<List<Upgrade>> =
        dao.observeAllUpgrades().map { list -> list.map { it.toDomain() } }

    // Prestige
    suspend fun getPrestige(): Prestige? = dao.getPrestige()?.toDomain()
    suspend fun savePrestige(prestige: Prestige) {
        dao.insertPrestige(prestige.toEntity())
    }

    // Settings
    suspend fun getSettings(): GameSettings =
        dao.getSettings()?.toDomain() ?: GameSettings()
    suspend fun saveSettings(settings: GameSettings) {
        dao.insertSettings(settings.toEntity())
    }

    // Statistics
    suspend fun getStatistics(): GameStatistics =
        dao.getStatistics()?.toDomain() ?: GameStatistics()
    suspend fun saveStatistics(stats: GameStatistics) {
        dao.insertStatistics(stats.toEntity())
    }

    // Serialization helpers
    private fun serializeGameState(state: GameState): GameStateEntity {
        return GameStateEntity(
            heroJson = json.encodeToString(state.hero),
            currentEnemyJson = state.currentEnemy?.let { json.encodeToString(it) },
            currentAreaId = state.currentAreaId,
            unlockedAreasJson = json.encodeToString(state.unlockedAreas),
            purchasedUpgradesJson = json.encodeToString(state.purchasedUpgrades),
            prestigeJson = json.encodeToString(state.prestige),
            lastSaved = Clock.System.now().toEpochMilliseconds(),
            totalPlayTime = state.totalPlayTime,
            settingsJson = json.encodeToString(state.settings),
            statisticsJson = json.encodeToString(state.statistics)
        )
    }

    private fun deserializeGameState(entity: GameStateEntity): GameState {
        return GameState(
            hero = json.decodeFromString(entity.heroJson),
            currentEnemy = entity.currentEnemyJson?.let { json.decodeFromString<Enemy>(it) },
            currentAreaId = entity.currentAreaId,
            unlockedAreas = json.decodeFromString(entity.unlockedAreasJson),
            purchasedUpgrades = json.decodeFromString(entity.purchasedUpgradesJson),
            prestige = json.decodeFromString(entity.prestigeJson),
            lastSaved = Instant.fromEpochMilliseconds(entity.lastSaved),
            totalPlayTime = entity.totalPlayTime,
            settings = json.decodeFromString(entity.settingsJson),
            statistics = json.decodeFromString(entity.statisticsJson)
        )
    }
}
