package com.rpgclicker.presentation.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rpgclicker.presentation.util.GameIcon
import com.rpgclicker.presentation.util.formatNumber

@Composable
fun GoldDisplay(gold: Long, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        GameIcon(name = "coin", modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = formatNumber(gold),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700)
        )
    }
}
