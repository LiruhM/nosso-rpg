package com.rpgclicker.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GameDao_Impl implements GameDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GameStateEntity> __insertionAdapterOfGameStateEntity;

  private final EntityInsertionAdapter<EnemyEntity> __insertionAdapterOfEnemyEntity;

  private final EntityInsertionAdapter<AreaEntity> __insertionAdapterOfAreaEntity;

  private final EntityInsertionAdapter<UpgradeEntity> __insertionAdapterOfUpgradeEntity;

  private final EntityInsertionAdapter<PrestigeEntity> __insertionAdapterOfPrestigeEntity;

  private final EntityInsertionAdapter<GameSettingsEntity> __insertionAdapterOfGameSettingsEntity;

  private final EntityInsertionAdapter<StatisticsEntity> __insertionAdapterOfStatisticsEntity;

  private final EntityDeletionOrUpdateAdapter<GameStateEntity> __updateAdapterOfGameStateEntity;

  private final EntityDeletionOrUpdateAdapter<EnemyEntity> __updateAdapterOfEnemyEntity;

  private final EntityDeletionOrUpdateAdapter<PrestigeEntity> __updateAdapterOfPrestigeEntity;

  private final EntityDeletionOrUpdateAdapter<StatisticsEntity> __updateAdapterOfStatisticsEntity;

  public GameDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGameStateEntity = new EntityInsertionAdapter<GameStateEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `game_state` (`id`,`heroJson`,`currentEnemyJson`,`currentAreaId`,`unlockedAreasJson`,`purchasedUpgradesJson`,`prestigeJson`,`lastSaved`,`totalPlayTime`,`settingsJson`,`statisticsJson`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameStateEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getHeroJson() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getHeroJson());
        }
        if (entity.getCurrentEnemyJson() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCurrentEnemyJson());
        }
        if (entity.getCurrentAreaId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCurrentAreaId());
        }
        if (entity.getUnlockedAreasJson() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUnlockedAreasJson());
        }
        if (entity.getPurchasedUpgradesJson() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPurchasedUpgradesJson());
        }
        if (entity.getPrestigeJson() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPrestigeJson());
        }
        statement.bindLong(8, entity.getLastSaved());
        statement.bindLong(9, entity.getTotalPlayTime());
        if (entity.getSettingsJson() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getSettingsJson());
        }
        if (entity.getStatisticsJson() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getStatisticsJson());
        }
      }
    };
    this.__insertionAdapterOfEnemyEntity = new EntityInsertionAdapter<EnemyEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `enemies` (`id`,`name`,`baseMaxHealth`,`currentHealth`,`baseGoldReward`,`baseExpReward`,`areaId`,`spriteIndex`,`maxHealth`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final EnemyEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getBaseMaxHealth());
        statement.bindLong(4, entity.getCurrentHealth());
        statement.bindLong(5, entity.getBaseGoldReward());
        statement.bindLong(6, entity.getBaseExpReward());
        if (entity.getAreaId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getAreaId());
        }
        statement.bindLong(8, entity.getSpriteIndex());
        statement.bindLong(9, entity.getMaxHealth());
      }
    };
    this.__insertionAdapterOfAreaEntity = new EntityInsertionAdapter<AreaEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `areas` (`id`,`name`,`orderIndex`,`enemyIdsJson`,`unlockRequirement`,`backgroundColor`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AreaEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getOrderIndex());
        if (entity.getEnemyIdsJson() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEnemyIdsJson());
        }
        statement.bindLong(5, entity.getUnlockRequirement());
        if (entity.getBackgroundColor() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getBackgroundColor());
        }
      }
    };
    this.__insertionAdapterOfUpgradeEntity = new EntityInsertionAdapter<UpgradeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `upgrades` (`id`,`name`,`description`,`type`,`baseCost`,`costMultiplier`,`baseValue`,`valueMultiplier`,`maxLevel`,`icon`,`prerequisiteId`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UpgradeEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getType() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getType());
        }
        statement.bindLong(5, entity.getBaseCost());
        statement.bindDouble(6, entity.getCostMultiplier());
        statement.bindDouble(7, entity.getBaseValue());
        statement.bindDouble(8, entity.getValueMultiplier());
        statement.bindLong(9, entity.getMaxLevel());
        if (entity.getIcon() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getIcon());
        }
        if (entity.getPrerequisiteId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPrerequisiteId());
        }
      }
    };
    this.__insertionAdapterOfPrestigeEntity = new EntityInsertionAdapter<PrestigeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `prestige` (`id`,`crystals`,`totalCrystalsEarned`,`globalMultiplier`,`prestigeCount`,`bestRunGold`,`bestRunTime`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PrestigeEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCrystals());
        statement.bindLong(3, entity.getTotalCrystalsEarned());
        statement.bindLong(4, entity.getGlobalMultiplier());
        statement.bindLong(5, entity.getPrestigeCount());
        statement.bindLong(6, entity.getBestRunGold());
        statement.bindLong(7, entity.getBestRunTime());
      }
    };
    this.__insertionAdapterOfGameSettingsEntity = new EntityInsertionAdapter<GameSettingsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `game_settings` (`id`,`soundEnabled`,`musicEnabled`,`vibrationsEnabled`,`autoSaveEnabled`,`showDamageNumbers`,`reducedAnimations`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameSettingsEntity entity) {
        statement.bindLong(1, entity.getId());
        final int _tmp = entity.getSoundEnabled() ? 1 : 0;
        statement.bindLong(2, _tmp);
        final int _tmp_1 = entity.getMusicEnabled() ? 1 : 0;
        statement.bindLong(3, _tmp_1);
        final int _tmp_2 = entity.getVibrationsEnabled() ? 1 : 0;
        statement.bindLong(4, _tmp_2);
        final int _tmp_3 = entity.getAutoSaveEnabled() ? 1 : 0;
        statement.bindLong(5, _tmp_3);
        final int _tmp_4 = entity.getShowDamageNumbers() ? 1 : 0;
        statement.bindLong(6, _tmp_4);
        final int _tmp_5 = entity.getReducedAnimations() ? 1 : 0;
        statement.bindLong(7, _tmp_5);
      }
    };
    this.__insertionAdapterOfStatisticsEntity = new EntityInsertionAdapter<StatisticsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `statistics` (`id`,`totalPlayTime`,`totalClicks`,`totalGoldEarned`,`totalGoldSpent`,`enemiesDefeated`,`bossesDefeated`,`timesPrestiged`,`highestLevelReached`,`highestAreaReached`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StatisticsEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTotalPlayTime());
        statement.bindLong(3, entity.getTotalClicks());
        statement.bindLong(4, entity.getTotalGoldEarned());
        statement.bindLong(5, entity.getTotalGoldSpent());
        statement.bindLong(6, entity.getEnemiesDefeated());
        statement.bindLong(7, entity.getBossesDefeated());
        statement.bindLong(8, entity.getTimesPrestiged());
        statement.bindLong(9, entity.getHighestLevelReached());
        if (entity.getHighestAreaReached() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getHighestAreaReached());
        }
      }
    };
    this.__updateAdapterOfGameStateEntity = new EntityDeletionOrUpdateAdapter<GameStateEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `game_state` SET `id` = ?,`heroJson` = ?,`currentEnemyJson` = ?,`currentAreaId` = ?,`unlockedAreasJson` = ?,`purchasedUpgradesJson` = ?,`prestigeJson` = ?,`lastSaved` = ?,`totalPlayTime` = ?,`settingsJson` = ?,`statisticsJson` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameStateEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getHeroJson() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getHeroJson());
        }
        if (entity.getCurrentEnemyJson() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCurrentEnemyJson());
        }
        if (entity.getCurrentAreaId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCurrentAreaId());
        }
        if (entity.getUnlockedAreasJson() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUnlockedAreasJson());
        }
        if (entity.getPurchasedUpgradesJson() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPurchasedUpgradesJson());
        }
        if (entity.getPrestigeJson() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPrestigeJson());
        }
        statement.bindLong(8, entity.getLastSaved());
        statement.bindLong(9, entity.getTotalPlayTime());
        if (entity.getSettingsJson() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getSettingsJson());
        }
        if (entity.getStatisticsJson() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getStatisticsJson());
        }
        statement.bindLong(12, entity.getId());
      }
    };
    this.__updateAdapterOfEnemyEntity = new EntityDeletionOrUpdateAdapter<EnemyEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `enemies` SET `id` = ?,`name` = ?,`baseMaxHealth` = ?,`currentHealth` = ?,`baseGoldReward` = ?,`baseExpReward` = ?,`areaId` = ?,`spriteIndex` = ?,`maxHealth` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final EnemyEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getBaseMaxHealth());
        statement.bindLong(4, entity.getCurrentHealth());
        statement.bindLong(5, entity.getBaseGoldReward());
        statement.bindLong(6, entity.getBaseExpReward());
        if (entity.getAreaId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getAreaId());
        }
        statement.bindLong(8, entity.getSpriteIndex());
        statement.bindLong(9, entity.getMaxHealth());
        if (entity.getId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getId());
        }
      }
    };
    this.__updateAdapterOfPrestigeEntity = new EntityDeletionOrUpdateAdapter<PrestigeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `prestige` SET `id` = ?,`crystals` = ?,`totalCrystalsEarned` = ?,`globalMultiplier` = ?,`prestigeCount` = ?,`bestRunGold` = ?,`bestRunTime` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PrestigeEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCrystals());
        statement.bindLong(3, entity.getTotalCrystalsEarned());
        statement.bindLong(4, entity.getGlobalMultiplier());
        statement.bindLong(5, entity.getPrestigeCount());
        statement.bindLong(6, entity.getBestRunGold());
        statement.bindLong(7, entity.getBestRunTime());
        statement.bindLong(8, entity.getId());
      }
    };
    this.__updateAdapterOfStatisticsEntity = new EntityDeletionOrUpdateAdapter<StatisticsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `statistics` SET `id` = ?,`totalPlayTime` = ?,`totalClicks` = ?,`totalGoldEarned` = ?,`totalGoldSpent` = ?,`enemiesDefeated` = ?,`bossesDefeated` = ?,`timesPrestiged` = ?,`highestLevelReached` = ?,`highestAreaReached` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StatisticsEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTotalPlayTime());
        statement.bindLong(3, entity.getTotalClicks());
        statement.bindLong(4, entity.getTotalGoldEarned());
        statement.bindLong(5, entity.getTotalGoldSpent());
        statement.bindLong(6, entity.getEnemiesDefeated());
        statement.bindLong(7, entity.getBossesDefeated());
        statement.bindLong(8, entity.getTimesPrestiged());
        statement.bindLong(9, entity.getHighestLevelReached());
        if (entity.getHighestAreaReached() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getHighestAreaReached());
        }
        statement.bindLong(11, entity.getId());
      }
    };
  }

  @Override
  public Object insertGameState(final GameStateEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGameStateEntity.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertEnemies(final List<EnemyEntity> enemies,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEnemyEntity.insert(enemies);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAreas(final List<AreaEntity> areas,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAreaEntity.insert(areas);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertUpgrades(final List<UpgradeEntity> upgrades,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUpgradeEntity.insert(upgrades);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertPrestige(final PrestigeEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPrestigeEntity.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSettings(final GameSettingsEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGameSettingsEntity.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertStatistics(final StatisticsEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStatisticsEntity.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateGameState(final GameStateEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfGameStateEntity.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateEnemy(final EnemyEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEnemyEntity.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePrestige(final PrestigeEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPrestigeEntity.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStatistics(final StatisticsEntity entity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfStatisticsEntity.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<GameStateEntity> getGameState() {
    final String _sql = "SELECT * FROM game_state WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"game_state"}, new Callable<GameStateEntity>() {
      @Override
      @Nullable
      public GameStateEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfHeroJson = CursorUtil.getColumnIndexOrThrow(_cursor, "heroJson");
          final int _cursorIndexOfCurrentEnemyJson = CursorUtil.getColumnIndexOrThrow(_cursor, "currentEnemyJson");
          final int _cursorIndexOfCurrentAreaId = CursorUtil.getColumnIndexOrThrow(_cursor, "currentAreaId");
          final int _cursorIndexOfUnlockedAreasJson = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockedAreasJson");
          final int _cursorIndexOfPurchasedUpgradesJson = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasedUpgradesJson");
          final int _cursorIndexOfPrestigeJson = CursorUtil.getColumnIndexOrThrow(_cursor, "prestigeJson");
          final int _cursorIndexOfLastSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSaved");
          final int _cursorIndexOfTotalPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPlayTime");
          final int _cursorIndexOfSettingsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "settingsJson");
          final int _cursorIndexOfStatisticsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "statisticsJson");
          final GameStateEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpHeroJson;
            if (_cursor.isNull(_cursorIndexOfHeroJson)) {
              _tmpHeroJson = null;
            } else {
              _tmpHeroJson = _cursor.getString(_cursorIndexOfHeroJson);
            }
            final String _tmpCurrentEnemyJson;
            if (_cursor.isNull(_cursorIndexOfCurrentEnemyJson)) {
              _tmpCurrentEnemyJson = null;
            } else {
              _tmpCurrentEnemyJson = _cursor.getString(_cursorIndexOfCurrentEnemyJson);
            }
            final String _tmpCurrentAreaId;
            if (_cursor.isNull(_cursorIndexOfCurrentAreaId)) {
              _tmpCurrentAreaId = null;
            } else {
              _tmpCurrentAreaId = _cursor.getString(_cursorIndexOfCurrentAreaId);
            }
            final String _tmpUnlockedAreasJson;
            if (_cursor.isNull(_cursorIndexOfUnlockedAreasJson)) {
              _tmpUnlockedAreasJson = null;
            } else {
              _tmpUnlockedAreasJson = _cursor.getString(_cursorIndexOfUnlockedAreasJson);
            }
            final String _tmpPurchasedUpgradesJson;
            if (_cursor.isNull(_cursorIndexOfPurchasedUpgradesJson)) {
              _tmpPurchasedUpgradesJson = null;
            } else {
              _tmpPurchasedUpgradesJson = _cursor.getString(_cursorIndexOfPurchasedUpgradesJson);
            }
            final String _tmpPrestigeJson;
            if (_cursor.isNull(_cursorIndexOfPrestigeJson)) {
              _tmpPrestigeJson = null;
            } else {
              _tmpPrestigeJson = _cursor.getString(_cursorIndexOfPrestigeJson);
            }
            final long _tmpLastSaved;
            _tmpLastSaved = _cursor.getLong(_cursorIndexOfLastSaved);
            final long _tmpTotalPlayTime;
            _tmpTotalPlayTime = _cursor.getLong(_cursorIndexOfTotalPlayTime);
            final String _tmpSettingsJson;
            if (_cursor.isNull(_cursorIndexOfSettingsJson)) {
              _tmpSettingsJson = null;
            } else {
              _tmpSettingsJson = _cursor.getString(_cursorIndexOfSettingsJson);
            }
            final String _tmpStatisticsJson;
            if (_cursor.isNull(_cursorIndexOfStatisticsJson)) {
              _tmpStatisticsJson = null;
            } else {
              _tmpStatisticsJson = _cursor.getString(_cursorIndexOfStatisticsJson);
            }
            _result = new GameStateEntity(_tmpId,_tmpHeroJson,_tmpCurrentEnemyJson,_tmpCurrentAreaId,_tmpUnlockedAreasJson,_tmpPurchasedUpgradesJson,_tmpPrestigeJson,_tmpLastSaved,_tmpTotalPlayTime,_tmpSettingsJson,_tmpStatisticsJson);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getGameStateOnce(final Continuation<? super GameStateEntity> $completion) {
    final String _sql = "SELECT * FROM game_state WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<GameStateEntity>() {
      @Override
      @Nullable
      public GameStateEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfHeroJson = CursorUtil.getColumnIndexOrThrow(_cursor, "heroJson");
          final int _cursorIndexOfCurrentEnemyJson = CursorUtil.getColumnIndexOrThrow(_cursor, "currentEnemyJson");
          final int _cursorIndexOfCurrentAreaId = CursorUtil.getColumnIndexOrThrow(_cursor, "currentAreaId");
          final int _cursorIndexOfUnlockedAreasJson = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockedAreasJson");
          final int _cursorIndexOfPurchasedUpgradesJson = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasedUpgradesJson");
          final int _cursorIndexOfPrestigeJson = CursorUtil.getColumnIndexOrThrow(_cursor, "prestigeJson");
          final int _cursorIndexOfLastSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSaved");
          final int _cursorIndexOfTotalPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPlayTime");
          final int _cursorIndexOfSettingsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "settingsJson");
          final int _cursorIndexOfStatisticsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "statisticsJson");
          final GameStateEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpHeroJson;
            if (_cursor.isNull(_cursorIndexOfHeroJson)) {
              _tmpHeroJson = null;
            } else {
              _tmpHeroJson = _cursor.getString(_cursorIndexOfHeroJson);
            }
            final String _tmpCurrentEnemyJson;
            if (_cursor.isNull(_cursorIndexOfCurrentEnemyJson)) {
              _tmpCurrentEnemyJson = null;
            } else {
              _tmpCurrentEnemyJson = _cursor.getString(_cursorIndexOfCurrentEnemyJson);
            }
            final String _tmpCurrentAreaId;
            if (_cursor.isNull(_cursorIndexOfCurrentAreaId)) {
              _tmpCurrentAreaId = null;
            } else {
              _tmpCurrentAreaId = _cursor.getString(_cursorIndexOfCurrentAreaId);
            }
            final String _tmpUnlockedAreasJson;
            if (_cursor.isNull(_cursorIndexOfUnlockedAreasJson)) {
              _tmpUnlockedAreasJson = null;
            } else {
              _tmpUnlockedAreasJson = _cursor.getString(_cursorIndexOfUnlockedAreasJson);
            }
            final String _tmpPurchasedUpgradesJson;
            if (_cursor.isNull(_cursorIndexOfPurchasedUpgradesJson)) {
              _tmpPurchasedUpgradesJson = null;
            } else {
              _tmpPurchasedUpgradesJson = _cursor.getString(_cursorIndexOfPurchasedUpgradesJson);
            }
            final String _tmpPrestigeJson;
            if (_cursor.isNull(_cursorIndexOfPrestigeJson)) {
              _tmpPrestigeJson = null;
            } else {
              _tmpPrestigeJson = _cursor.getString(_cursorIndexOfPrestigeJson);
            }
            final long _tmpLastSaved;
            _tmpLastSaved = _cursor.getLong(_cursorIndexOfLastSaved);
            final long _tmpTotalPlayTime;
            _tmpTotalPlayTime = _cursor.getLong(_cursorIndexOfTotalPlayTime);
            final String _tmpSettingsJson;
            if (_cursor.isNull(_cursorIndexOfSettingsJson)) {
              _tmpSettingsJson = null;
            } else {
              _tmpSettingsJson = _cursor.getString(_cursorIndexOfSettingsJson);
            }
            final String _tmpStatisticsJson;
            if (_cursor.isNull(_cursorIndexOfStatisticsJson)) {
              _tmpStatisticsJson = null;
            } else {
              _tmpStatisticsJson = _cursor.getString(_cursorIndexOfStatisticsJson);
            }
            _result = new GameStateEntity(_tmpId,_tmpHeroJson,_tmpCurrentEnemyJson,_tmpCurrentAreaId,_tmpUnlockedAreasJson,_tmpPurchasedUpgradesJson,_tmpPrestigeJson,_tmpLastSaved,_tmpTotalPlayTime,_tmpSettingsJson,_tmpStatisticsJson);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getEnemy(final String id, final Continuation<? super EnemyEntity> $completion) {
    final String _sql = "SELECT * FROM enemies WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<EnemyEntity>() {
      @Override
      @Nullable
      public EnemyEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfBaseMaxHealth = CursorUtil.getColumnIndexOrThrow(_cursor, "baseMaxHealth");
          final int _cursorIndexOfCurrentHealth = CursorUtil.getColumnIndexOrThrow(_cursor, "currentHealth");
          final int _cursorIndexOfBaseGoldReward = CursorUtil.getColumnIndexOrThrow(_cursor, "baseGoldReward");
          final int _cursorIndexOfBaseExpReward = CursorUtil.getColumnIndexOrThrow(_cursor, "baseExpReward");
          final int _cursorIndexOfAreaId = CursorUtil.getColumnIndexOrThrow(_cursor, "areaId");
          final int _cursorIndexOfSpriteIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "spriteIndex");
          final int _cursorIndexOfMaxHealth = CursorUtil.getColumnIndexOrThrow(_cursor, "maxHealth");
          final EnemyEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpBaseMaxHealth;
            _tmpBaseMaxHealth = _cursor.getInt(_cursorIndexOfBaseMaxHealth);
            final int _tmpCurrentHealth;
            _tmpCurrentHealth = _cursor.getInt(_cursorIndexOfCurrentHealth);
            final int _tmpBaseGoldReward;
            _tmpBaseGoldReward = _cursor.getInt(_cursorIndexOfBaseGoldReward);
            final int _tmpBaseExpReward;
            _tmpBaseExpReward = _cursor.getInt(_cursorIndexOfBaseExpReward);
            final String _tmpAreaId;
            if (_cursor.isNull(_cursorIndexOfAreaId)) {
              _tmpAreaId = null;
            } else {
              _tmpAreaId = _cursor.getString(_cursorIndexOfAreaId);
            }
            final int _tmpSpriteIndex;
            _tmpSpriteIndex = _cursor.getInt(_cursorIndexOfSpriteIndex);
            final int _tmpMaxHealth;
            _tmpMaxHealth = _cursor.getInt(_cursorIndexOfMaxHealth);
            _result = new EnemyEntity(_tmpId,_tmpName,_tmpBaseMaxHealth,_tmpCurrentHealth,_tmpBaseGoldReward,_tmpBaseExpReward,_tmpAreaId,_tmpSpriteIndex,_tmpMaxHealth);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getEnemiesByArea(final String areaId,
      final Continuation<? super List<EnemyEntity>> $completion) {
    final String _sql = "SELECT * FROM enemies WHERE areaId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (areaId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, areaId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<EnemyEntity>>() {
      @Override
      @NonNull
      public List<EnemyEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfBaseMaxHealth = CursorUtil.getColumnIndexOrThrow(_cursor, "baseMaxHealth");
          final int _cursorIndexOfCurrentHealth = CursorUtil.getColumnIndexOrThrow(_cursor, "currentHealth");
          final int _cursorIndexOfBaseGoldReward = CursorUtil.getColumnIndexOrThrow(_cursor, "baseGoldReward");
          final int _cursorIndexOfBaseExpReward = CursorUtil.getColumnIndexOrThrow(_cursor, "baseExpReward");
          final int _cursorIndexOfAreaId = CursorUtil.getColumnIndexOrThrow(_cursor, "areaId");
          final int _cursorIndexOfSpriteIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "spriteIndex");
          final int _cursorIndexOfMaxHealth = CursorUtil.getColumnIndexOrThrow(_cursor, "maxHealth");
          final List<EnemyEntity> _result = new ArrayList<EnemyEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final EnemyEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpBaseMaxHealth;
            _tmpBaseMaxHealth = _cursor.getInt(_cursorIndexOfBaseMaxHealth);
            final int _tmpCurrentHealth;
            _tmpCurrentHealth = _cursor.getInt(_cursorIndexOfCurrentHealth);
            final int _tmpBaseGoldReward;
            _tmpBaseGoldReward = _cursor.getInt(_cursorIndexOfBaseGoldReward);
            final int _tmpBaseExpReward;
            _tmpBaseExpReward = _cursor.getInt(_cursorIndexOfBaseExpReward);
            final String _tmpAreaId;
            if (_cursor.isNull(_cursorIndexOfAreaId)) {
              _tmpAreaId = null;
            } else {
              _tmpAreaId = _cursor.getString(_cursorIndexOfAreaId);
            }
            final int _tmpSpriteIndex;
            _tmpSpriteIndex = _cursor.getInt(_cursorIndexOfSpriteIndex);
            final int _tmpMaxHealth;
            _tmpMaxHealth = _cursor.getInt(_cursorIndexOfMaxHealth);
            _item = new EnemyEntity(_tmpId,_tmpName,_tmpBaseMaxHealth,_tmpCurrentHealth,_tmpBaseGoldReward,_tmpBaseExpReward,_tmpAreaId,_tmpSpriteIndex,_tmpMaxHealth);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getArea(final String id, final Continuation<? super AreaEntity> $completion) {
    final String _sql = "SELECT * FROM areas WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AreaEntity>() {
      @Override
      @Nullable
      public AreaEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfOrderIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "orderIndex");
          final int _cursorIndexOfEnemyIdsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "enemyIdsJson");
          final int _cursorIndexOfUnlockRequirement = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockRequirement");
          final int _cursorIndexOfBackgroundColor = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundColor");
          final AreaEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpOrderIndex;
            _tmpOrderIndex = _cursor.getInt(_cursorIndexOfOrderIndex);
            final String _tmpEnemyIdsJson;
            if (_cursor.isNull(_cursorIndexOfEnemyIdsJson)) {
              _tmpEnemyIdsJson = null;
            } else {
              _tmpEnemyIdsJson = _cursor.getString(_cursorIndexOfEnemyIdsJson);
            }
            final int _tmpUnlockRequirement;
            _tmpUnlockRequirement = _cursor.getInt(_cursorIndexOfUnlockRequirement);
            final String _tmpBackgroundColor;
            if (_cursor.isNull(_cursorIndexOfBackgroundColor)) {
              _tmpBackgroundColor = null;
            } else {
              _tmpBackgroundColor = _cursor.getString(_cursorIndexOfBackgroundColor);
            }
            _result = new AreaEntity(_tmpId,_tmpName,_tmpOrderIndex,_tmpEnemyIdsJson,_tmpUnlockRequirement,_tmpBackgroundColor);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllAreas(final Continuation<? super List<AreaEntity>> $completion) {
    final String _sql = "SELECT * FROM areas ORDER BY orderIndex";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AreaEntity>>() {
      @Override
      @NonNull
      public List<AreaEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfOrderIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "orderIndex");
          final int _cursorIndexOfEnemyIdsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "enemyIdsJson");
          final int _cursorIndexOfUnlockRequirement = CursorUtil.getColumnIndexOrThrow(_cursor, "unlockRequirement");
          final int _cursorIndexOfBackgroundColor = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundColor");
          final List<AreaEntity> _result = new ArrayList<AreaEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AreaEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpOrderIndex;
            _tmpOrderIndex = _cursor.getInt(_cursorIndexOfOrderIndex);
            final String _tmpEnemyIdsJson;
            if (_cursor.isNull(_cursorIndexOfEnemyIdsJson)) {
              _tmpEnemyIdsJson = null;
            } else {
              _tmpEnemyIdsJson = _cursor.getString(_cursorIndexOfEnemyIdsJson);
            }
            final int _tmpUnlockRequirement;
            _tmpUnlockRequirement = _cursor.getInt(_cursorIndexOfUnlockRequirement);
            final String _tmpBackgroundColor;
            if (_cursor.isNull(_cursorIndexOfBackgroundColor)) {
              _tmpBackgroundColor = null;
            } else {
              _tmpBackgroundColor = _cursor.getString(_cursorIndexOfBackgroundColor);
            }
            _item = new AreaEntity(_tmpId,_tmpName,_tmpOrderIndex,_tmpEnemyIdsJson,_tmpUnlockRequirement,_tmpBackgroundColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUpgrade(final String id, final Continuation<? super UpgradeEntity> $completion) {
    final String _sql = "SELECT * FROM upgrades WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UpgradeEntity>() {
      @Override
      @Nullable
      public UpgradeEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfBaseCost = CursorUtil.getColumnIndexOrThrow(_cursor, "baseCost");
          final int _cursorIndexOfCostMultiplier = CursorUtil.getColumnIndexOrThrow(_cursor, "costMultiplier");
          final int _cursorIndexOfBaseValue = CursorUtil.getColumnIndexOrThrow(_cursor, "baseValue");
          final int _cursorIndexOfValueMultiplier = CursorUtil.getColumnIndexOrThrow(_cursor, "valueMultiplier");
          final int _cursorIndexOfMaxLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "maxLevel");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfPrerequisiteId = CursorUtil.getColumnIndexOrThrow(_cursor, "prerequisiteId");
          final UpgradeEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final int _tmpBaseCost;
            _tmpBaseCost = _cursor.getInt(_cursorIndexOfBaseCost);
            final double _tmpCostMultiplier;
            _tmpCostMultiplier = _cursor.getDouble(_cursorIndexOfCostMultiplier);
            final double _tmpBaseValue;
            _tmpBaseValue = _cursor.getDouble(_cursorIndexOfBaseValue);
            final double _tmpValueMultiplier;
            _tmpValueMultiplier = _cursor.getDouble(_cursorIndexOfValueMultiplier);
            final int _tmpMaxLevel;
            _tmpMaxLevel = _cursor.getInt(_cursorIndexOfMaxLevel);
            final String _tmpIcon;
            if (_cursor.isNull(_cursorIndexOfIcon)) {
              _tmpIcon = null;
            } else {
              _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
            }
            final String _tmpPrerequisiteId;
            if (_cursor.isNull(_cursorIndexOfPrerequisiteId)) {
              _tmpPrerequisiteId = null;
            } else {
              _tmpPrerequisiteId = _cursor.getString(_cursorIndexOfPrerequisiteId);
            }
            _result = new UpgradeEntity(_tmpId,_tmpName,_tmpDescription,_tmpType,_tmpBaseCost,_tmpCostMultiplier,_tmpBaseValue,_tmpValueMultiplier,_tmpMaxLevel,_tmpIcon,_tmpPrerequisiteId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllUpgrades(final Continuation<? super List<UpgradeEntity>> $completion) {
    final String _sql = "SELECT * FROM upgrades";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UpgradeEntity>>() {
      @Override
      @NonNull
      public List<UpgradeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfBaseCost = CursorUtil.getColumnIndexOrThrow(_cursor, "baseCost");
          final int _cursorIndexOfCostMultiplier = CursorUtil.getColumnIndexOrThrow(_cursor, "costMultiplier");
          final int _cursorIndexOfBaseValue = CursorUtil.getColumnIndexOrThrow(_cursor, "baseValue");
          final int _cursorIndexOfValueMultiplier = CursorUtil.getColumnIndexOrThrow(_cursor, "valueMultiplier");
          final int _cursorIndexOfMaxLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "maxLevel");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfPrerequisiteId = CursorUtil.getColumnIndexOrThrow(_cursor, "prerequisiteId");
          final List<UpgradeEntity> _result = new ArrayList<UpgradeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UpgradeEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final int _tmpBaseCost;
            _tmpBaseCost = _cursor.getInt(_cursorIndexOfBaseCost);
            final double _tmpCostMultiplier;
            _tmpCostMultiplier = _cursor.getDouble(_cursorIndexOfCostMultiplier);
            final double _tmpBaseValue;
            _tmpBaseValue = _cursor.getDouble(_cursorIndexOfBaseValue);
            final double _tmpValueMultiplier;
            _tmpValueMultiplier = _cursor.getDouble(_cursorIndexOfValueMultiplier);
            final int _tmpMaxLevel;
            _tmpMaxLevel = _cursor.getInt(_cursorIndexOfMaxLevel);
            final String _tmpIcon;
            if (_cursor.isNull(_cursorIndexOfIcon)) {
              _tmpIcon = null;
            } else {
              _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
            }
            final String _tmpPrerequisiteId;
            if (_cursor.isNull(_cursorIndexOfPrerequisiteId)) {
              _tmpPrerequisiteId = null;
            } else {
              _tmpPrerequisiteId = _cursor.getString(_cursorIndexOfPrerequisiteId);
            }
            _item = new UpgradeEntity(_tmpId,_tmpName,_tmpDescription,_tmpType,_tmpBaseCost,_tmpCostMultiplier,_tmpBaseValue,_tmpValueMultiplier,_tmpMaxLevel,_tmpIcon,_tmpPrerequisiteId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<UpgradeEntity>> observeAllUpgrades() {
    final String _sql = "SELECT * FROM upgrades";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"upgrades"}, new Callable<List<UpgradeEntity>>() {
      @Override
      @NonNull
      public List<UpgradeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfBaseCost = CursorUtil.getColumnIndexOrThrow(_cursor, "baseCost");
          final int _cursorIndexOfCostMultiplier = CursorUtil.getColumnIndexOrThrow(_cursor, "costMultiplier");
          final int _cursorIndexOfBaseValue = CursorUtil.getColumnIndexOrThrow(_cursor, "baseValue");
          final int _cursorIndexOfValueMultiplier = CursorUtil.getColumnIndexOrThrow(_cursor, "valueMultiplier");
          final int _cursorIndexOfMaxLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "maxLevel");
          final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
          final int _cursorIndexOfPrerequisiteId = CursorUtil.getColumnIndexOrThrow(_cursor, "prerequisiteId");
          final List<UpgradeEntity> _result = new ArrayList<UpgradeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UpgradeEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final int _tmpBaseCost;
            _tmpBaseCost = _cursor.getInt(_cursorIndexOfBaseCost);
            final double _tmpCostMultiplier;
            _tmpCostMultiplier = _cursor.getDouble(_cursorIndexOfCostMultiplier);
            final double _tmpBaseValue;
            _tmpBaseValue = _cursor.getDouble(_cursorIndexOfBaseValue);
            final double _tmpValueMultiplier;
            _tmpValueMultiplier = _cursor.getDouble(_cursorIndexOfValueMultiplier);
            final int _tmpMaxLevel;
            _tmpMaxLevel = _cursor.getInt(_cursorIndexOfMaxLevel);
            final String _tmpIcon;
            if (_cursor.isNull(_cursorIndexOfIcon)) {
              _tmpIcon = null;
            } else {
              _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
            }
            final String _tmpPrerequisiteId;
            if (_cursor.isNull(_cursorIndexOfPrerequisiteId)) {
              _tmpPrerequisiteId = null;
            } else {
              _tmpPrerequisiteId = _cursor.getString(_cursorIndexOfPrerequisiteId);
            }
            _item = new UpgradeEntity(_tmpId,_tmpName,_tmpDescription,_tmpType,_tmpBaseCost,_tmpCostMultiplier,_tmpBaseValue,_tmpValueMultiplier,_tmpMaxLevel,_tmpIcon,_tmpPrerequisiteId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getPrestige(final Continuation<? super PrestigeEntity> $completion) {
    final String _sql = "SELECT * FROM prestige WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PrestigeEntity>() {
      @Override
      @Nullable
      public PrestigeEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCrystals = CursorUtil.getColumnIndexOrThrow(_cursor, "crystals");
          final int _cursorIndexOfTotalCrystalsEarned = CursorUtil.getColumnIndexOrThrow(_cursor, "totalCrystalsEarned");
          final int _cursorIndexOfGlobalMultiplier = CursorUtil.getColumnIndexOrThrow(_cursor, "globalMultiplier");
          final int _cursorIndexOfPrestigeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "prestigeCount");
          final int _cursorIndexOfBestRunGold = CursorUtil.getColumnIndexOrThrow(_cursor, "bestRunGold");
          final int _cursorIndexOfBestRunTime = CursorUtil.getColumnIndexOrThrow(_cursor, "bestRunTime");
          final PrestigeEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpCrystals;
            _tmpCrystals = _cursor.getInt(_cursorIndexOfCrystals);
            final int _tmpTotalCrystalsEarned;
            _tmpTotalCrystalsEarned = _cursor.getInt(_cursorIndexOfTotalCrystalsEarned);
            final int _tmpGlobalMultiplier;
            _tmpGlobalMultiplier = _cursor.getInt(_cursorIndexOfGlobalMultiplier);
            final int _tmpPrestigeCount;
            _tmpPrestigeCount = _cursor.getInt(_cursorIndexOfPrestigeCount);
            final long _tmpBestRunGold;
            _tmpBestRunGold = _cursor.getLong(_cursorIndexOfBestRunGold);
            final long _tmpBestRunTime;
            _tmpBestRunTime = _cursor.getLong(_cursorIndexOfBestRunTime);
            _result = new PrestigeEntity(_tmpId,_tmpCrystals,_tmpTotalCrystalsEarned,_tmpGlobalMultiplier,_tmpPrestigeCount,_tmpBestRunGold,_tmpBestRunTime);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getSettings(final Continuation<? super GameSettingsEntity> $completion) {
    final String _sql = "SELECT * FROM game_settings WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<GameSettingsEntity>() {
      @Override
      @Nullable
      public GameSettingsEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSoundEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "soundEnabled");
          final int _cursorIndexOfMusicEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "musicEnabled");
          final int _cursorIndexOfVibrationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "vibrationsEnabled");
          final int _cursorIndexOfAutoSaveEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "autoSaveEnabled");
          final int _cursorIndexOfShowDamageNumbers = CursorUtil.getColumnIndexOrThrow(_cursor, "showDamageNumbers");
          final int _cursorIndexOfReducedAnimations = CursorUtil.getColumnIndexOrThrow(_cursor, "reducedAnimations");
          final GameSettingsEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final boolean _tmpSoundEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfSoundEnabled);
            _tmpSoundEnabled = _tmp != 0;
            final boolean _tmpMusicEnabled;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfMusicEnabled);
            _tmpMusicEnabled = _tmp_1 != 0;
            final boolean _tmpVibrationsEnabled;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfVibrationsEnabled);
            _tmpVibrationsEnabled = _tmp_2 != 0;
            final boolean _tmpAutoSaveEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfAutoSaveEnabled);
            _tmpAutoSaveEnabled = _tmp_3 != 0;
            final boolean _tmpShowDamageNumbers;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfShowDamageNumbers);
            _tmpShowDamageNumbers = _tmp_4 != 0;
            final boolean _tmpReducedAnimations;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfReducedAnimations);
            _tmpReducedAnimations = _tmp_5 != 0;
            _result = new GameSettingsEntity(_tmpId,_tmpSoundEnabled,_tmpMusicEnabled,_tmpVibrationsEnabled,_tmpAutoSaveEnabled,_tmpShowDamageNumbers,_tmpReducedAnimations);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getStatistics(final Continuation<? super StatisticsEntity> $completion) {
    final String _sql = "SELECT * FROM statistics WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<StatisticsEntity>() {
      @Override
      @Nullable
      public StatisticsEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTotalPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPlayTime");
          final int _cursorIndexOfTotalClicks = CursorUtil.getColumnIndexOrThrow(_cursor, "totalClicks");
          final int _cursorIndexOfTotalGoldEarned = CursorUtil.getColumnIndexOrThrow(_cursor, "totalGoldEarned");
          final int _cursorIndexOfTotalGoldSpent = CursorUtil.getColumnIndexOrThrow(_cursor, "totalGoldSpent");
          final int _cursorIndexOfEnemiesDefeated = CursorUtil.getColumnIndexOrThrow(_cursor, "enemiesDefeated");
          final int _cursorIndexOfBossesDefeated = CursorUtil.getColumnIndexOrThrow(_cursor, "bossesDefeated");
          final int _cursorIndexOfTimesPrestiged = CursorUtil.getColumnIndexOrThrow(_cursor, "timesPrestiged");
          final int _cursorIndexOfHighestLevelReached = CursorUtil.getColumnIndexOrThrow(_cursor, "highestLevelReached");
          final int _cursorIndexOfHighestAreaReached = CursorUtil.getColumnIndexOrThrow(_cursor, "highestAreaReached");
          final StatisticsEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final long _tmpTotalPlayTime;
            _tmpTotalPlayTime = _cursor.getLong(_cursorIndexOfTotalPlayTime);
            final long _tmpTotalClicks;
            _tmpTotalClicks = _cursor.getLong(_cursorIndexOfTotalClicks);
            final long _tmpTotalGoldEarned;
            _tmpTotalGoldEarned = _cursor.getLong(_cursorIndexOfTotalGoldEarned);
            final long _tmpTotalGoldSpent;
            _tmpTotalGoldSpent = _cursor.getLong(_cursorIndexOfTotalGoldSpent);
            final int _tmpEnemiesDefeated;
            _tmpEnemiesDefeated = _cursor.getInt(_cursorIndexOfEnemiesDefeated);
            final int _tmpBossesDefeated;
            _tmpBossesDefeated = _cursor.getInt(_cursorIndexOfBossesDefeated);
            final int _tmpTimesPrestiged;
            _tmpTimesPrestiged = _cursor.getInt(_cursorIndexOfTimesPrestiged);
            final int _tmpHighestLevelReached;
            _tmpHighestLevelReached = _cursor.getInt(_cursorIndexOfHighestLevelReached);
            final String _tmpHighestAreaReached;
            if (_cursor.isNull(_cursorIndexOfHighestAreaReached)) {
              _tmpHighestAreaReached = null;
            } else {
              _tmpHighestAreaReached = _cursor.getString(_cursorIndexOfHighestAreaReached);
            }
            _result = new StatisticsEntity(_tmpId,_tmpTotalPlayTime,_tmpTotalClicks,_tmpTotalGoldEarned,_tmpTotalGoldSpent,_tmpEnemiesDefeated,_tmpBossesDefeated,_tmpTimesPrestiged,_tmpHighestLevelReached,_tmpHighestAreaReached);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
