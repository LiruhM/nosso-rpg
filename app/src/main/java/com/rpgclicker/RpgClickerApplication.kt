package com.rpgclicker

import android.app.Application
import com.rpgclicker.data.local.GameDao
import com.rpgclicker.data.local.GameDatabase

class RpgClickerApplication : Application() {

    var gameDatabase: GameDatabase? = null
        private set

    override fun onCreate() {
        super.onCreate()
        gameDatabase = GameDatabase.getDatabase(applicationContext)
    }

    fun getGameDao(): GameDao = gameDatabase!!.gameDao()
}
