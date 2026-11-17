package com.rpgclicker.presentation.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rpgclicker.domain.model.Enemy
import com.rpgclicker.presentation.util.EnemySprite
import com.rpgclicker.presentation.util.GameIcon
import com.rpgclicker.presentation.util.formatNumber

@Composable
fun EnemyCard(
    modifier: Modifier = Modifier,
    enemy: Enemy,
    onAttack: () -> Unit
) {
    val animatedHealth by animateFloatAsState(
        targetValue = enemy.healthPercent,
        animationSpec = spring(dampingRatio = 0.8f),
        label = "enemyHealth"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onAttack() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFFFFFFF).copy(alpha = 0.1f))
        ) {
            EnemySprite(
                spriteIndex = enemy.spriteIndex,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = enemy.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "${formatNumber(enemy.currentHealth.toLong())} / ${formatNumber(enemy.maxHealth.toLong())}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF1E1E2E))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(animatedHealth.coerceIn(0f, 1f))
                        .fillMaxHeight()
                        .background(
                            if (animatedHealth > 0.5f) Color(0xFF00D4AA)
                            else if (animatedHealth > 0.25f) Color(0xFFFFD700)
                            else Color(0xFFFF4757)
                        )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                RewardItem(
                    iconLabel = "coin",
                    label = "Ouro",
                    value = formatNumber(enemy.goldReward.toLong()),
                    color = Color(0xFFFFD700)
                )
                RewardItem(
                    iconLabel = "star",
                    label = "XP",
                    value = formatNumber(enemy.expReward.toLong()),
                    color = Color(0xFF9B59B6)
                )
            }
        }
    }
}

@Composable
private fun RewardItem(
    iconLabel: String,
    label: String,
    value: String,
    color: Color,
    canAfford: Boolean = true
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        GameIcon(
            name = iconLabel,
            modifier = Modifier.size(20.dp),
            colorFilter = if (canAfford) null else ColorFilter.tint(Color(0xFF8B949E))
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = Color.White
        )
    }
}
