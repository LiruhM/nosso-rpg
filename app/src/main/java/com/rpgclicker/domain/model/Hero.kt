package com.rpgclicker.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    val name: String = "Heroi",
    val level: Int = 1,
    val gold: Long = 0,
    val clickPower: Double = 1.0,
    val autoDps: Double = 0.0,
    val maxHealth: Int = 100,
    var currentHealth: Int = 100,
    val experience: Int = 0,
    val experienceToNextLevel: Int = 100,
    val critChance: Double = 0.05,
    val critDamageMultiplier: Double = 2.0,
    val goldMultiplier: Double = 1.0
)
