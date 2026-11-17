package com.rpgclicker.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/rpgclicker/data/local/GameDatabase;", "Landroidx/room/RoomDatabase;", "()V", "gameDao", "Lcom/rpgclicker/data/local/GameDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.rpgclicker.data.local.GameStateEntity.class, com.rpgclicker.data.local.EnemyEntity.class, com.rpgclicker.data.local.AreaEntity.class, com.rpgclicker.data.local.UpgradeEntity.class, com.rpgclicker.data.local.PrestigeEntity.class, com.rpgclicker.data.local.GameSettingsEntity.class, com.rpgclicker.data.local.StatisticsEntity.class}, version = 1, exportSchema = false)
public abstract class GameDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.rpgclicker.data.local.GameDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.rpgclicker.data.local.GameDatabase.Companion Companion = null;
    
    public GameDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.rpgclicker.data.local.GameDao gameDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/rpgclicker/data/local/GameDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/rpgclicker/data/local/GameDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.rpgclicker.data.local.GameDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}