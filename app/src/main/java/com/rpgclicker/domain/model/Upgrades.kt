package com.rpgclicker.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Upgrade(
    val id: String,
    val name: String,
    val description: String,
    val type: UpgradeType,
    val baseCost: Int,
    val costMultiplier: Double,
    val baseValue: Double,
    val valueMultiplier: Double,
    val maxLevel: Int,
    val icon: String? = null,
    val prerequisiteId: String? = null
) {
    fun currentCost(level: Int): Int {
        return (baseCost * Math.pow(costMultiplier, level.toDouble())).toInt()
    }

    fun currentValue(level: Int): Double {
        return baseValue * Math.pow(valueMultiplier, level.toDouble())
    }

    enum class UpgradeType {
        CLICK_POWER, AUTO_DPS, GOLD_MULTIPLIER, HEALTH, CRIT_CHANCE, CRIT_DAMAGE
    }
}

@Serializable
data class UpgradePurchase(
    val upgradeId: String,
    val level: Int
)
