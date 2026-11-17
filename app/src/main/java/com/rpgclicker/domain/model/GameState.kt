package com.rpgclicker.domain.model

import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable

@Serializable
data class Area(
    val id: String,
    val name: String,
    val order: Int,
    val enemyIds: List<String>,
    val unlockRequirement: Int,
    val backgroundColor: String
)

@Serializable
data class Prestige(
    val crystals: Int = 0,
    val totalCrystalsEarned: Int = 0,
    val globalMultiplier: Int = 0,
    val prestigeCount: Int = 0,
    val bestRunGold: Long = 0,
    val bestRunTime: Long = 0
)

@Serializable
data class GameSettings(
    val soundEnabled: Boolean = true,
    val musicEnabled: Boolean = true,
    val vibrationsEnabled: Boolean = true,
    val autoSaveEnabled: Boolean = true,
    val showDamageNumbers: Boolean = true,
    val reducedAnimations: Boolean = false
)

@Serializable
data class GameStatistics(
    val totalPlayTime: Long = 0,
    val totalClicks: Long = 0,
    val totalGoldEarned: Long = 0,
    val totalGoldSpent: Long = 0,
    val enemiesDefeated: Int = 0,
    val bossesDefeated: Int = 0,
    val timesPrestiged: Int = 0,
    val highestLevelReached: Int = 1,
    val highestAreaReached: String = "area_01"
)

@Serializable
data class GameState(
    val hero: Hero = Hero(),
    val currentEnemy: Enemy? = null,
    val currentAreaId: String = "area_01",
    val unlockedAreas: Set<String> = setOf("area_01"),
    val purchasedUpgrades: Map<String, Int> = emptyMap(),
    val prestige: Prestige = Prestige(),
    val lastSaved: kotlinx.datetime.Instant = Clock.System.now(),
    val totalPlayTime: Long = 0,
    val settings: GameSettings = GameSettings(),
    val statistics: GameStatistics = GameStatistics()
) {
    /** Prestigio liberado quando o heroi tem ao menos 1000 de ouro (1 cristal a cada 1000). */
    fun canPrestige(): Boolean = hero.gold >= PRESTIGE_GOLD_PER_CRYSTAL

    fun crystalsOnPrestige(): Int = (hero.gold / PRESTIGE_GOLD_PER_CRYSTAL).toInt()

    companion object {
        const val PRESTIGE_GOLD_PER_CRYSTAL = 1000L
    }
}
