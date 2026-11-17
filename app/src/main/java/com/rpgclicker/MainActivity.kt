package com.rpgclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.rpgclicker.data.repository.GameRepository
import com.rpgclicker.domain.usecase.GameEngine
import com.rpgclicker.presentation.screen.MainScreen
import com.rpgclicker.presentation.util.GameViewModelFactory
import com.rpgclicker.presentation.viewmodel.GameViewModel
import com.rpgclicker.ui.theme.RpgClicker

class MainActivity : ComponentActivity() {

    private val viewModel: GameViewModel by viewModels {
        val app = application as RpgClickerApplication
        val repository = GameRepository(app.gameDatabase!!, applicationContext)
        val gameEngine = GameEngine(repository)
        GameViewModelFactory(repository, gameEngine)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(AppLifecycleObserver(viewModel))
        setContent {
            RpgClicker {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}

class AppLifecycleObserver(private val viewModel: GameViewModel) : DefaultLifecycleObserver {
    override fun onResume(owner: LifecycleOwner) {
        viewModel.onAppForeground()
    }
}
