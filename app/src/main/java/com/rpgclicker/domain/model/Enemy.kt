package com.rpgclicker.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Enemy(
    val id: String,
    val name: String,
    val baseMaxHealth: Int,
    var currentHealth: Int,
    val baseGoldReward: Int,
    val baseExpReward: Int,
    val areaId: String,
    val spriteIndex: Int = 0
) {
    var maxHealth: Int = baseMaxHealth

    val isAlive: Boolean
        get() = currentHealth > 0

    val healthPercent: Float
        get() = if (maxHealth <= 0) 0f else currentHealth.toFloat() / maxHealth

    fun takeDamage(amount: Int): Boolean {
        val wasAlive = currentHealth > 0
        currentHealth = kotlin.math.max(currentHealth - amount, 0)
        return wasAlive && currentHealth <= 0
    }

    fun heal(amount: Int) {
        currentHealth = kotlin.math.min(currentHealth + amount, maxHealth)
    }

    /** Copia do inimigo com a vida informada (preserva maxHealth, que nao entra no copy()). */
    fun withHealth(health: Int): Enemy =
        copy(currentHealth = health).also { it.maxHealth = maxHealth }

    /** Copia do inimigo com a vida cheia. */
    fun fresh(): Enemy = withHealth(maxHealth)

    val goldReward: Int
        get() = baseGoldReward

    val expReward: Int
        get() = baseExpReward
}
