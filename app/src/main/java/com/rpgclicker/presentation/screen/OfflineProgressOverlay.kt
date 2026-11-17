package com.rpgclicker.presentation.screen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.rpgclicker.domain.usecase.OfflineProgress
import com.rpgclicker.presentation.util.formatNumber

@Composable
fun OfflineProgressOverlay(
    progress: OfflineProgress,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Bem-vindo de volta!") },
        text = {
            Text(
                "Enquanto voce estava fora, seu heroi ganhou " +
                    "${formatNumber(progress.gold)} de ouro e ${formatNumber(progress.exp.toLong())} de XP."
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Coletar") }
        }
    )
}
