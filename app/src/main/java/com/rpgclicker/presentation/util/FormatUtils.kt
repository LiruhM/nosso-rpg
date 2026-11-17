package com.rpgclicker.presentation.util

import java.util.Locale

fun formatNumber(value: Long): String {
    return when {
        value >= 1_000_000_000 -> "${(value / 1_000_000_000.0).format(1)}B"
        value >= 1_000_000 -> "${(value / 1_000_000.0).format(1)}M"
        value >= 1_000 -> "${(value / 1_000.0).format(1)}k"
        else -> value.toString()
    }
}

fun Double.format(decimals: Int): String =
    String.format(Locale.US, "%.${decimals}f", this)
