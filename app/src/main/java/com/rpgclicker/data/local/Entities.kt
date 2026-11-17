package com.rpgclicker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_state")
data class GameStateEntity(
    @PrimaryKey val id: Int = 1,
    val heroJson: String,
    val currentEnemyJson: String?,
    val currentAreaId: String,
    val unlockedAreasJson: String,
    val purchasedUpgradesJson: String,
    val prestigeJson: String,
    val lastSaved: Long,
    val totalPlayTime: Long,
    val settingsJson: String,
    val statisticsJson: String
)

@Entity(tableName = "enemies")
data class EnemyEntity(
    @PrimaryKey val id: String,
    val name: String,
    val baseMaxHealth: Int,
    var currentHealth: Int,
    val baseGoldReward: Int,
    val baseExpReward: Int,
    val areaId: String,
    val spriteIndex: Int,
    val maxHealth: Int
)

@Entity(tableName = "areas")
data class AreaEntity(
    @PrimaryKey val id: String,
    val name: String,
    val orderIndex: Int,
    val enemyIdsJson: String,
    val unlockRequirement: Int,
    val backgroundColor: String
)

@Entity(tableName = "upgrades")
data class UpgradeEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val type: String,
    val baseCost: Int,
    val costMultiplier: Double,
    val baseValue: Double,
    val valueMultiplier: Double,
    val maxLevel: Int,
    val icon: String?,
    val prerequisiteId: String?
)

@Entity(tableName = "prestige")
data class PrestigeEntity(
    @PrimaryKey val id: Int = 1,
    val crystals: Int = 0,
    val totalCrystalsEarned: Int = 0,
    val globalMultiplier: Int = 0,
    val prestigeCount: Int = 0,
    val bestRunGold: Long = 0,
    val bestRunTime: Long = 0
)

@Entity(tableName = "game_settings")
data class GameSettingsEntity(
    @PrimaryKey val id: Int = 1,
    val soundEnabled: Boolean = true,
    val musicEnabled: Boolean = true,
    val vibrationsEnabled: Boolean = true,
    val autoSaveEnabled: Boolean = true,
    val showDamageNumbers: Boolean = true,
    val reducedAnimations: Boolean = false
)

@Entity(tableName = "statistics")
data class StatisticsEntity(
    @PrimaryKey val id: Int = 1,
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
