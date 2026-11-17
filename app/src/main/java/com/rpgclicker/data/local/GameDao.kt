package com.rpgclicker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    // Game State
    @Query("SELECT * FROM game_state WHERE id = 1")
    fun getGameState(): Flow<GameStateEntity?>

    @Query("SELECT * FROM game_state WHERE id = 1")
    suspend fun getGameStateOnce(): GameStateEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameState(entity: GameStateEntity)

    @Update
    suspend fun updateGameState(entity: GameStateEntity)

    // Enemies
    @Query("SELECT * FROM enemies WHERE id = :id")
    suspend fun getEnemy(id: String): EnemyEntity?

    @Query("SELECT * FROM enemies WHERE areaId = :areaId")
    suspend fun getEnemiesByArea(areaId: String): List<EnemyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEnemies(enemies: List<EnemyEntity>)

    @Update
    suspend fun updateEnemy(entity: EnemyEntity)

    // Areas
    @Query("SELECT * FROM areas WHERE id = :id")
    suspend fun getArea(id: String): AreaEntity?

    @Query("SELECT * FROM areas ORDER BY orderIndex")
    suspend fun getAllAreas(): List<AreaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAreas(areas: List<AreaEntity>)

    // Upgrades
    @Query("SELECT * FROM upgrades WHERE id = :id")
    suspend fun getUpgrade(id: String): UpgradeEntity?

    @Query("SELECT * FROM upgrades")
    suspend fun getAllUpgrades(): List<UpgradeEntity>

    @Query("SELECT * FROM upgrades")
    fun observeAllUpgrades(): Flow<List<UpgradeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpgrades(upgrades: List<UpgradeEntity>)

    // Prestige
    @Query("SELECT * FROM prestige WHERE id = 1")
    suspend fun getPrestige(): PrestigeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrestige(entity: PrestigeEntity)

    @Update
    suspend fun updatePrestige(entity: PrestigeEntity)

    // Settings
    @Query("SELECT * FROM game_settings WHERE id = 1")
    suspend fun getSettings(): GameSettingsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSettings(entity: GameSettingsEntity)

    // Statistics
    @Query("SELECT * FROM statistics WHERE id = 1")
    suspend fun getStatistics(): StatisticsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStatistics(entity: StatisticsEntity)

    @Update
    suspend fun updateStatistics(entity: StatisticsEntity)
}
