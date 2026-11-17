@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.rpgclicker.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.rpgclicker.presentation.util.GameIcon
import com.rpgclicker.presentation.util.formatNumber
import com.rpgclicker.presentation.viewmodel.GameViewModel

@Composable
fun UpgradesSheet(
    viewModel: GameViewModel,
    onDismiss: () -> Unit
) {
    val state by viewModel.gameState.collectAsState()
    val upgrades by viewModel.upgrades.collectAsState()

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = "Melhorias",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(upgrades.sortedBy { it.baseCost }, key = { it.id }) { upgrade ->
                    val level = state.purchasedUpgrades[upgrade.id] ?: 0
                    val maxed = level >= upgrade.maxLevel
                    val cost = upgrade.currentCost(level)
                    val prereqMet = upgrade.prerequisiteId == null ||
                        (state.purchasedUpgrades[upgrade.prerequisiteId] ?: 0) > 0
                    val canBuy = !maxed && prereqMet && state.hero.gold >= cost

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            GameIcon(name = upgrade.icon, modifier = Modifier.size(36.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "${upgrade.name} (${level}/${upgrade.maxLevel})",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = upgrade.description,
                                    style = MaterialTheme.typography.bodySmall
                                )
                                if (!prereqMet) {
                                    Text(
                                        text = "Requer outra melhoria",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                }
                            }
                            Button(
                                onClick = { viewModel.purchaseUpgrade(upgrade.id) },
                                enabled = canBuy
                            ) {
                                Text(if (maxed) "MAX" else formatNumber(cost.toLong()))
                            }
                        }
                    }
                }
                item { androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(bottom = 24.dp)) }
            }
        }
    }
}
