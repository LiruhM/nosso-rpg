package com.rpgclicker.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GameDatabase_Impl extends GameDatabase {
  private volatile GameDao _gameDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `game_state` (`id` INTEGER NOT NULL, `heroJson` TEXT NOT NULL, `currentEnemyJson` TEXT, `currentAreaId` TEXT NOT NULL, `unlockedAreasJson` TEXT NOT NULL, `purchasedUpgradesJson` TEXT NOT NULL, `prestigeJson` TEXT NOT NULL, `lastSaved` INTEGER NOT NULL, `totalPlayTime` INTEGER NOT NULL, `settingsJson` TEXT NOT NULL, `statisticsJson` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `enemies` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `baseMaxHealth` INTEGER NOT NULL, `currentHealth` INTEGER NOT NULL, `baseGoldReward` INTEGER NOT NULL, `baseExpReward` INTEGER NOT NULL, `areaId` TEXT NOT NULL, `spriteIndex` INTEGER NOT NULL, `maxHealth` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `areas` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `orderIndex` INTEGER NOT NULL, `enemyIdsJson` TEXT NOT NULL, `unlockRequirement` INTEGER NOT NULL, `backgroundColor` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `upgrades` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `type` TEXT NOT NULL, `baseCost` INTEGER NOT NULL, `costMultiplier` REAL NOT NULL, `baseValue` REAL NOT NULL, `valueMultiplier` REAL NOT NULL, `maxLevel` INTEGER NOT NULL, `icon` TEXT, `prerequisiteId` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `prestige` (`id` INTEGER NOT NULL, `crystals` INTEGER NOT NULL, `totalCrystalsEarned` INTEGER NOT NULL, `globalMultiplier` INTEGER NOT NULL, `prestigeCount` INTEGER NOT NULL, `bestRunGold` INTEGER NOT NULL, `bestRunTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `game_settings` (`id` INTEGER NOT NULL, `soundEnabled` INTEGER NOT NULL, `musicEnabled` INTEGER NOT NULL, `vibrationsEnabled` INTEGER NOT NULL, `autoSaveEnabled` INTEGER NOT NULL, `showDamageNumbers` INTEGER NOT NULL, `reducedAnimations` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `statistics` (`id` INTEGER NOT NULL, `totalPlayTime` INTEGER NOT NULL, `totalClicks` INTEGER NOT NULL, `totalGoldEarned` INTEGER NOT NULL, `totalGoldSpent` INTEGER NOT NULL, `enemiesDefeated` INTEGER NOT NULL, `bossesDefeated` INTEGER NOT NULL, `timesPrestiged` INTEGER NOT NULL, `highestLevelReached` INTEGER NOT NULL, `highestAreaReached` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ea4fbd0c1d14fcb7ec2ca984efd9fa3b')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `game_state`");
        db.execSQL("DROP TABLE IF EXISTS `enemies`");
        db.execSQL("DROP TABLE IF EXISTS `areas`");
        db.execSQL("DROP TABLE IF EXISTS `upgrades`");
        db.execSQL("DROP TABLE IF EXISTS `prestige`");
        db.execSQL("DROP TABLE IF EXISTS `game_settings`");
        db.execSQL("DROP TABLE IF EXISTS `statistics`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsGameState = new HashMap<String, TableInfo.Column>(11);
        _columnsGameState.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("heroJson", new TableInfo.Column("heroJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("currentEnemyJson", new TableInfo.Column("currentEnemyJson", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("currentAreaId", new TableInfo.Column("currentAreaId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("unlockedAreasJson", new TableInfo.Column("unlockedAreasJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("purchasedUpgradesJson", new TableInfo.Column("purchasedUpgradesJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("prestigeJson", new TableInfo.Column("prestigeJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("lastSaved", new TableInfo.Column("lastSaved", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("totalPlayTime", new TableInfo.Column("totalPlayTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("settingsJson", new TableInfo.Column("settingsJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameState.put("statisticsJson", new TableInfo.Column("statisticsJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGameState = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGameState = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGameState = new TableInfo("game_state", _columnsGameState, _foreignKeysGameState, _indicesGameState);
        final TableInfo _existingGameState = TableInfo.read(db, "game_state");
        if (!_infoGameState.equals(_existingGameState)) {
          return new RoomOpenHelper.ValidationResult(false, "game_state(com.rpgclicker.data.local.GameStateEntity).\n"
                  + " Expected:\n" + _infoGameState + "\n"
                  + " Found:\n" + _existingGameState);
        }
        final HashMap<String, TableInfo.Column> _columnsEnemies = new HashMap<String, TableInfo.Column>(9);
        _columnsEnemies.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnemies.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnemies.put("baseMaxHealth", new TableInfo.Column("baseMaxHealth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnemies.put("currentHealth", new TableInfo.Column("currentHealth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnemies.put("baseGoldReward", new TableInfo.Column("baseGoldReward", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnemies.put("baseExpReward", new TableInfo.Column("baseExpReward", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnemies.put("areaId", new TableInfo.Column("areaId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnemies.put("spriteIndex", new TableInfo.Column("spriteIndex", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnemies.put("maxHealth", new TableInfo.Column("maxHealth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEnemies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEnemies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEnemies = new TableInfo("enemies", _columnsEnemies, _foreignKeysEnemies, _indicesEnemies);
        final TableInfo _existingEnemies = TableInfo.read(db, "enemies");
        if (!_infoEnemies.equals(_existingEnemies)) {
          return new RoomOpenHelper.ValidationResult(false, "enemies(com.rpgclicker.data.local.EnemyEntity).\n"
                  + " Expected:\n" + _infoEnemies + "\n"
                  + " Found:\n" + _existingEnemies);
        }
        final HashMap<String, TableInfo.Column> _columnsAreas = new HashMap<String, TableInfo.Column>(6);
        _columnsAreas.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAreas.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAreas.put("orderIndex", new TableInfo.Column("orderIndex", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAreas.put("enemyIdsJson", new TableInfo.Column("enemyIdsJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAreas.put("unlockRequirement", new TableInfo.Column("unlockRequirement", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAreas.put("backgroundColor", new TableInfo.Column("backgroundColor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAreas = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAreas = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAreas = new TableInfo("areas", _columnsAreas, _foreignKeysAreas, _indicesAreas);
        final TableInfo _existingAreas = TableInfo.read(db, "areas");
        if (!_infoAreas.equals(_existingAreas)) {
          return new RoomOpenHelper.ValidationResult(false, "areas(com.rpgclicker.data.local.AreaEntity).\n"
                  + " Expected:\n" + _infoAreas + "\n"
                  + " Found:\n" + _existingAreas);
        }
        final HashMap<String, TableInfo.Column> _columnsUpgrades = new HashMap<String, TableInfo.Column>(11);
        _columnsUpgrades.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("baseCost", new TableInfo.Column("baseCost", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("costMultiplier", new TableInfo.Column("costMultiplier", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("baseValue", new TableInfo.Column("baseValue", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("valueMultiplier", new TableInfo.Column("valueMultiplier", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("maxLevel", new TableInfo.Column("maxLevel", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("prerequisiteId", new TableInfo.Column("prerequisiteId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUpgrades = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUpgrades = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUpgrades = new TableInfo("upgrades", _columnsUpgrades, _foreignKeysUpgrades, _indicesUpgrades);
        final TableInfo _existingUpgrades = TableInfo.read(db, "upgrades");
        if (!_infoUpgrades.equals(_existingUpgrades)) {
          return new RoomOpenHelper.ValidationResult(false, "upgrades(com.rpgclicker.data.local.UpgradeEntity).\n"
                  + " Expected:\n" + _infoUpgrades + "\n"
                  + " Found:\n" + _existingUpgrades);
        }
        final HashMap<String, TableInfo.Column> _columnsPrestige = new HashMap<String, TableInfo.Column>(7);
        _columnsPrestige.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrestige.put("crystals", new TableInfo.Column("crystals", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrestige.put("totalCrystalsEarned", new TableInfo.Column("totalCrystalsEarned", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrestige.put("globalMultiplier", new TableInfo.Column("globalMultiplier", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrestige.put("prestigeCount", new TableInfo.Column("prestigeCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrestige.put("bestRunGold", new TableInfo.Column("bestRunGold", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrestige.put("bestRunTime", new TableInfo.Column("bestRunTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPrestige = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPrestige = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPrestige = new TableInfo("prestige", _columnsPrestige, _foreignKeysPrestige, _indicesPrestige);
        final TableInfo _existingPrestige = TableInfo.read(db, "prestige");
        if (!_infoPrestige.equals(_existingPrestige)) {
          return new RoomOpenHelper.ValidationResult(false, "prestige(com.rpgclicker.data.local.PrestigeEntity).\n"
                  + " Expected:\n" + _infoPrestige + "\n"
                  + " Found:\n" + _existingPrestige);
        }
        final HashMap<String, TableInfo.Column> _columnsGameSettings = new HashMap<String, TableInfo.Column>(7);
        _columnsGameSettings.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameSettings.put("soundEnabled", new TableInfo.Column("soundEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameSettings.put("musicEnabled", new TableInfo.Column("musicEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameSettings.put("vibrationsEnabled", new TableInfo.Column("vibrationsEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameSettings.put("autoSaveEnabled", new TableInfo.Column("autoSaveEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameSettings.put("showDamageNumbers", new TableInfo.Column("showDamageNumbers", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameSettings.put("reducedAnimations", new TableInfo.Column("reducedAnimations", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGameSettings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGameSettings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGameSettings = new TableInfo("game_settings", _columnsGameSettings, _foreignKeysGameSettings, _indicesGameSettings);
        final TableInfo _existingGameSettings = TableInfo.read(db, "game_settings");
        if (!_infoGameSettings.equals(_existingGameSettings)) {
          return new RoomOpenHelper.ValidationResult(false, "game_settings(com.rpgclicker.data.local.GameSettingsEntity).\n"
                  + " Expected:\n" + _infoGameSettings + "\n"
                  + " Found:\n" + _existingGameSettings);
        }
        final HashMap<String, TableInfo.Column> _columnsStatistics = new HashMap<String, TableInfo.Column>(10);
        _columnsStatistics.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("totalPlayTime", new TableInfo.Column("totalPlayTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("totalClicks", new TableInfo.Column("totalClicks", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("totalGoldEarned", new TableInfo.Column("totalGoldEarned", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("totalGoldSpent", new TableInfo.Column("totalGoldSpent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("enemiesDefeated", new TableInfo.Column("enemiesDefeated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("bossesDefeated", new TableInfo.Column("bossesDefeated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("timesPrestiged", new TableInfo.Column("timesPrestiged", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("highestLevelReached", new TableInfo.Column("highestLevelReached", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatistics.put("highestAreaReached", new TableInfo.Column("highestAreaReached", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStatistics = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStatistics = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStatistics = new TableInfo("statistics", _columnsStatistics, _foreignKeysStatistics, _indicesStatistics);
        final TableInfo _existingStatistics = TableInfo.read(db, "statistics");
        if (!_infoStatistics.equals(_existingStatistics)) {
          return new RoomOpenHelper.ValidationResult(false, "statistics(com.rpgclicker.data.local.StatisticsEntity).\n"
                  + " Expected:\n" + _infoStatistics + "\n"
                  + " Found:\n" + _existingStatistics);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ea4fbd0c1d14fcb7ec2ca984efd9fa3b", "20d420a387f62f8409909ef23522b607");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "game_state","enemies","areas","upgrades","prestige","game_settings","statistics");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `game_state`");
      _db.execSQL("DELETE FROM `enemies`");
      _db.execSQL("DELETE FROM `areas`");
      _db.execSQL("DELETE FROM `upgrades`");
      _db.execSQL("DELETE FROM `prestige`");
      _db.execSQL("DELETE FROM `game_settings`");
      _db.execSQL("DELETE FROM `statistics`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(GameDao.class, GameDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public GameDao gameDao() {
    if (_gameDao != null) {
      return _gameDao;
    } else {
      synchronized(this) {
        if(_gameDao == null) {
          _gameDao = new GameDao_Impl(this);
        }
        return _gameDao;
      }
    }
  }
}
