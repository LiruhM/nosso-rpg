package com.rpgclicker.data.local

import com.rpgclicker.domain.model.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun Hero.toJson(): String = Json.encodeToString(this)

fun String.toHero(): Hero = Json.decodeFromString(this)

fun Enemy.toEntity(): EnemyEntity = EnemyEntity(
    id = id,
    name = name,
    baseMaxHealth = baseMaxHealth,
    currentHealth = currentHealth,
    baseGoldReward = baseGoldReward,
    baseExpReward = baseExpReward,
    areaId = areaId,
    spriteIndex = spriteIndex,
    maxHealth = maxHealth
)

fun EnemyEntity.toDomain(): Enemy = Enemy(
    id = id,
    name = name,
    baseMaxHealth = baseMaxHealth,
    currentHealth = currentHealth,
    baseGoldReward = baseGoldReward,
    baseExpReward = baseExpReward,
    areaId = areaId,
    spriteIndex = spriteIndex
).also { it.maxHealth = maxHealth }

fun Area.toEntity(): AreaEntity = AreaEntity(
    id = id,
    name = name,
    orderIndex = order,
    enemyIdsJson = Json.encodeToString(enemyIds),
    unlockRequirement = unlockRequirement,
    backgroundColor = backgroundColor
)

fun AreaEntity.toDomain(): Area = Area(
    id = id,
    name = name,
    order = orderIndex,
    enemyIds = Json.decodeFromString(enemyIdsJson),
    unlockRequirement = unlockRequirement,
    backgroundColor = backgroundColor
)

fun Upgrade.toEntity(): UpgradeEntity = UpgradeEntity(
    id = id,
    name = name,
    description = description,
    type = type.name,
    baseCost = baseCost,
    costMultiplier = costMultiplier,
    baseValue = baseValue,
    valueMultiplier = valueMultiplier,
    maxLevel = maxLevel,
    icon = icon,
    prerequisiteId = prerequisiteId
)

fun UpgradeEntity.toDomain(): Upgrade = Upgrade(
    id = id,
    name = name,
    description = description,
    type = Upgrade.UpgradeType.valueOf(type),
    baseCost = baseCost,
    costMultiplier = costMultiplier,
    baseValue = baseValue,
    valueMultiplier = valueMultiplier,
    maxLevel = maxLevel,
    icon = icon,
    prerequisiteId = prerequisiteId
)

fun Prestige.toEntity(): PrestigeEntity = PrestigeEntity(
    crystals = crystals,
    totalCrystalsEarned = totalCrystalsEarned,
    globalMultiplier = globalMultiplier,
    prestigeCount = prestigeCount,
    bestRunGold = bestRunGold,
    bestRunTime = bestRunTime
)

fun PrestigeEntity.toDomain(): Prestige = Prestige(
    crystals = crystals,
    totalCrystalsEarned = totalCrystalsEarned,
    globalMultiplier = globalMultiplier,
    prestigeCount = prestigeCount,
    bestRunGold = bestRunGold,
    bestRunTime = bestRunTime
)

fun GameSettings.toEntity(): GameSettingsEntity = GameSettingsEntity(
    soundEnabled = soundEnabled,
    musicEnabled = musicEnabled,
    vibrationsEnabled = vibrationsEnabled,
    autoSaveEnabled = autoSaveEnabled,
    showDamageNumbers = showDamageNumbers,
    reducedAnimations = reducedAnimations
)

fun GameSettingsEntity.toDomain(): GameSettings = GameSettings(
    soundEnabled = soundEnabled,
    musicEnabled = musicEnabled,
    vibrationsEnabled = vibrationsEnabled,
    autoSaveEnabled = autoSaveEnabled,
    showDamageNumbers = showDamageNumbers,
    reducedAnimations = reducedAnimations
)

fun GameStatistics.toEntity(): StatisticsEntity = StatisticsEntity(
    totalPlayTime = totalPlayTime,
    totalClicks = totalClicks,
    totalGoldEarned = totalGoldEarned,
    totalGoldSpent = totalGoldSpent,
    enemiesDefeated = enemiesDefeated,
    bossesDefeated = bossesDefeated,
    timesPrestiged = timesPrestiged,
    highestLevelReached = highestLevelReached,
    highestAreaReached = highestAreaReached
)

fun StatisticsEntity.toDomain(): GameStatistics = GameStatistics(
    totalPlayTime = totalPlayTime,
    totalClicks = totalClicks,
    totalGoldEarned = totalGoldEarned,
    totalGoldSpent = totalGoldSpent,
    enemiesDefeated = enemiesDefeated,
    bossesDefeated = bossesDefeated,
    timesPrestiged = timesPrestiged,
    highestLevelReached = highestLevelReached,
    highestAreaReached = highestAreaReached
)
