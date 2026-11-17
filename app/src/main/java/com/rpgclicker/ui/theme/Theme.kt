package com.rpgclicker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00D4AA),
    surface = Color(0xFF161622),
    background = Color(0xFF0D0D14),
    error = Color(0xFFFF4757),
    onPrimary = Color(0xFF0D0D14),
    onSurface = Color(0xFFFFFFFF),
    onBackground = Color(0xFFFFFFFF)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00A88A),
    surface = Color(0xFFFFFFFF),
    background = Color(0xFFF5F5F5),
    error = Color(0xFFDC3545)
)

@Composable
fun RpgClicker(
    content: @Composable () -> Unit
) {
    val colorScheme = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
