package com.rpgclicker.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rpgclicker.domain.model.Hero
import com.rpgclicker.domain.model.Prestige
import com.rpgclicker.presentation.util.format
import com.rpgclicker.presentation.util.formatNumber

@Composable
fun HeroStatsCard(
    hero: Hero,
    prestige: Prestige,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${hero.name} - Nv ${hero.level}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Vida ${hero.currentHealth}/${hero.maxHealth}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            LinearProgressIndicator(
                progress = { (hero.experience.toFloat() / hero.experienceToNextLevel).coerceIn(0f, 1f) },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "XP ${formatNumber(hero.experience.toLong())} / ${formatNumber(hero.experienceToNextLevel.toLong())}",
                style = MaterialTheme.typography.labelSmall
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Toque: ${hero.clickPower.format(1)}", style = MaterialTheme.typography.bodyMedium)
                Text("DPS: ${hero.autoDps.format(1)}", style = MaterialTheme.typography.bodyMedium)
                Text("Crit: ${(hero.critChance * 100).format(0)}%", style = MaterialTheme.typography.bodyMedium)
            }

            if (prestige.prestigeCount > 0) {
                Text(
                    text = "Prestigios: ${prestige.prestigeCount} (bonus de ouro +${prestige.globalMultiplier * 10}%)",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}
