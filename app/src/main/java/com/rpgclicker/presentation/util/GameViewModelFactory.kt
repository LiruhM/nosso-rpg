package com.rpgclicker.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rpgclicker.data.repository.GameRepository
import com.rpgclicker.domain.usecase.GameEngine
import com.rpgclicker.presentation.viewmodel.GameViewModel

class GameViewModelFactory(
    private val repository: GameRepository,
    private val gameEngine: GameEngine
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GameViewModel(repository, gameEngine) as T
    }
}
