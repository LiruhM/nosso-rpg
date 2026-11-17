package com.rpgclicker.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/** Placeholder simples; pode ser removido quando todos os icones usarem GameIcon. */
@Composable
fun IconPlaceholder(
    modifier: Modifier = Modifier.size(24.dp),
    color: Color = Color(0xFF8B949E)
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color)
    )
}
