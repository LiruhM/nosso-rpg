@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.rpgclicker.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rpgclicker.presentation.util.formatNumber
import com.rpgclicker.presentation.viewmodel.GameViewModel

@Composable
fun PrestigeSheet(
    viewModel: GameViewModel,
    onDismiss: () -> Unit
) {
    val state by viewModel.gameState.collectAsState()
    val crystalsToGain = state.crystalsOnPrestige()

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Prestigio",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            PrestigeDisplay(crystals = state.prestige.crystals)
            Text(
                text = "Reinicie a jornada (nivel, ouro e melhorias voltam ao inicio) " +
                    "e ganhe cristais e +10% de ouro permanente.",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Cristais a ganhar: ${formatNumber(crystalsToGain.toLong())}",
                style = MaterialTheme.typography.titleMedium
            )
            Button(
                onClick = {
                    viewModel.doPrestige()
                    onDismiss()
                },
                enabled = state.canPrestige(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Fazer prestigio")
            }
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(bottom = 24.dp))
        }
    }
}
