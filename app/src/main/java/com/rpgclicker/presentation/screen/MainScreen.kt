@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.rpgclicker.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rpgclicker.R
import com.rpgclicker.presentation.util.GameIcon
import com.rpgclicker.presentation.viewmodel.GameViewModel

@Composable
fun MainScreen(
    viewModel: GameViewModel = viewModel()
) {
    val gameState by viewModel.gameState.collectAsState()
    val enemy = gameState.currentEnemy
    val autoBattleEnabled by viewModel.autoBattleEnabled.collectAsState()
    val attackResult by viewModel.lastAttackResult.collectAsState()
    val offlineProgress by viewModel.offlineProgress.collectAsState()

    var showUpgrades by remember { mutableStateOf(false) }
    var showPrestige by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name_short)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                actions = {
                    Row(
                        modifier = Modifier.padding(end = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        GoldDisplay(gold = gameState.hero.gold)
                        if (gameState.prestige.crystals > 0) {
                            PrestigeDisplay(crystals = gameState.prestige.crystals)
                        }
                        IconButton(onClick = { viewModel.toggleAutoBattle() }) {
                            GameIcon(
                                name = if (autoBattleEnabled) "fist" else "star",
                                modifier = Modifier.size(24.dp),
                                colorFilter = if (autoBattleEnabled) null
                                else ColorFilter.tint(Color(0xFF8B949E))
                            )
                        }
                    }
                }
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(
                        id = when (gameState.currentAreaId) {
                            "area_02" -> R.drawable.bg_area_02
                            "area_03" -> R.drawable.bg_area_03
                            "area_04" -> R.drawable.bg_area_04
                            "area_05" -> R.drawable.bg_area_05
                            "area_10" -> R.drawable.bg_area_10
                            else -> R.drawable.bg_area_01
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                if (enemy != null) {
                    EnemyCard(
                        enemy = enemy,
                        onAttack = { viewModel.onTapAttack() }
                    )
                } else {
                    Text(
                        text = "Nenhum inimigo na area",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            HeroStatsCard(hero = gameState.hero, prestige = gameState.prestige)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { showUpgrades = true },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Melhorias")
                }
                Button(
                    onClick = { showPrestige = true },
                    modifier = Modifier.weight(1f),
                    enabled = gameState.canPrestige()
                ) {
                    Text("Prestigio")
                }
            }
        }

        if (showUpgrades) {
            UpgradesSheet(
                viewModel = viewModel,
                onDismiss = { showUpgrades = false }
            )
        }

        if (showPrestige) {
            PrestigeSheet(
                viewModel = viewModel,
                onDismiss = { showPrestige = false }
            )
        }

        attackResult?.let { result ->
            AttackFeedbackOverlay(
                result = result,
                onDismiss = { viewModel.dismissAttackResult() }
            )
        }

        offlineProgress?.let { progress ->
            OfflineProgressOverlay(
                progress = progress,
                onDismiss = { viewModel.dismissOfflineProgress() }
            )
        }
    }
}
