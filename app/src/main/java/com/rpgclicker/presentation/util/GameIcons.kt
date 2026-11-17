package com.rpgclicker.presentation.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rpgclicker.R

object GameIcons {
    val byName: Map<String, Int> = mapOf(
        "fist" to R.drawable.ic_fist,
        "glove" to R.drawable.ic_glove,
        "gauntlet" to R.drawable.ic_gauntlet,
        "goblin" to R.drawable.ic_goblin,
        "wolf" to R.drawable.ic_wolf,
        "skeleton" to R.drawable.ic_skeleton,
        "coin" to R.drawable.ic_coin,
        "bag" to R.drawable.ic_bag,
        "heart" to R.drawable.ic_heart,
        "eye" to R.drawable.ic_eye,
        "dagger" to R.drawable.ic_dagger,
        "star" to R.drawable.ic_star,
        "hero" to R.drawable.sprite_hero,
        "enemy" to R.drawable.sprite_enemy
    )

    fun get(name: String?): Int = byName[name ?: "enemy"] ?: R.drawable.sprite_enemy
}

@Composable
fun GameIcon(
    name: String?,
    modifier: Modifier = Modifier.size(24.dp),
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painterResource(id = GameIcons.get(name)),
        contentDescription = null,
        modifier = modifier,
        colorFilter = colorFilter
    )
}

@Composable
fun EnemySprite(
    spriteIndex: Int,
    modifier: Modifier = Modifier.size(64.dp)
) {
    val drawableId = when (spriteIndex) {
        0 -> R.drawable.enemy_slime
        1 -> R.drawable.enemy_goblin
        2 -> R.drawable.enemy_wolf
        3 -> R.drawable.enemy_bandit
        4 -> R.drawable.enemy_orc
        5 -> R.drawable.enemy_skeleton
        6 -> R.drawable.enemy_troll
        7 -> R.drawable.enemy_dragon_whelp
        8 -> R.drawable.enemy_dark_knight
        9 -> R.drawable.enemy_ancient_dragon
        else -> R.drawable.sprite_enemy
    }
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = null,
        modifier = modifier
    )
}
