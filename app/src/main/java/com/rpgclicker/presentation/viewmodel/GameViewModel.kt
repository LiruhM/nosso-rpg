package com.rpgclicker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rpgclicker.data.repository.GameRepository
import com.rpgclicker.domain.model.GameState
import com.rpgclicker.domain.model.Upgrade
import com.rpgclicker.domain.usecase.AttackResult
import com.rpgclicker.domain.usecase.GameEngine
import com.rpgclicker.domain.usecase.OfflineProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GameViewModel(
    private val repository: GameRepository,
    private val gameEngine: GameEngine
) : ViewModel() {

    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    val upgrades: StateFlow<List<Upgrade>> = repository.getAllUpgradesFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _lastAttackResult = MutableStateFlow<AttackResult?>(null)
    val lastAttackResult: StateFlow<AttackResult?> = _lastAttackResult.asStateFlow()

    private val _offlineProgress = MutableStateFlow<OfflineProgress?>(null)
    val offlineProgress: StateFlow<OfflineProgress?> = _offlineProgress.asStateFlow()

    private val _autoBattleEnabled = MutableStateFlow(false)
    val autoBattleEnabled: StateFlow<Boolean> = _autoBattleEnabled.asStateFlow()

    init {
        loadGame()
    }

    private fun loadGame() {
        viewModelScope.launch {
            gameEngine.ensureInitialState()
            repository.observeGameState().collect { state ->
                _gameState.value = state
            }
        }
    }

    fun onTapAttack() {
        viewModelScope.launch {
            _lastAttackResult.value = gameEngine.onTapAttack()
        }
    }

    fun purchaseUpgrade(upgradeId: String) {
        viewModelScope.launch {
            gameEngine.purchaseUpgrade(upgradeId)
        }
    }

    fun doPrestige() {
        viewModelScope.launch {
            gameEngine.doPrestige()
        }
    }

    fun toggleAutoBattle() {
        val enabled = !_autoBattleEnabled.value
        _autoBattleEnabled.value = enabled
        if (enabled) gameEngine.startAutoBattle() else gameEngine.stopAutoBattle()
    }

    fun onAppForeground() {
        viewModelScope.launch {
            val progress = gameEngine.applyOfflineProgress()
            if (progress.gold > 0 || progress.exp > 0) {
                _offlineProgress.value = progress
            }
        }
    }

    fun dismissOfflineProgress() {
        _offlineProgress.value = null
    }

    fun dismissAttackResult() {
        _lastAttackResult.value = null
    }

    override fun onCleared() {
        super.onCleared()
        gameEngine.stopAutoBattle()
    }
}
