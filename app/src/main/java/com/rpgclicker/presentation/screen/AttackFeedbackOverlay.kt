package com.rpgclicker.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rpgclicker.domain.usecase.AttackResult
import com.rpgclicker.presentation.util.formatNumber
import kotlinx.coroutines.delay

@Composable
fun AttackFeedbackOverlay(
    result: AttackResult,
    onDismiss: () -> Unit
) {
    // Some sozinho pouco depois de cada ataque
    LaunchedEffect(result) {
        delay(600)
        onDismiss()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 120.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = (if (result.isCritical) "CRIT! " else "") + "-${formatNumber(result.damage.toLong())}",
            style = if (result.isCritical) MaterialTheme.typography.headlineMedium
            else MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = if (result.isCritical) Color(0xFFFFD700) else Color(0xFFFF4757)
        )
        if (result.enemyDefeated) {
            Text(
                text = "Derrotado! +${formatNumber(result.goldEarned.toLong())} ouro",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF00D4AA),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp)
            )
        }
    }
}
