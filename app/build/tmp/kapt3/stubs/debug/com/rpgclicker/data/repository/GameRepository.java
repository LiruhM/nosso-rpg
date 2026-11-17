package com.rpgclicker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00100\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00102\u0006\u0010\u001d\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010!\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010#\u001a\u00020$H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010%\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010&\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0012J\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\f0\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0002J\u001c\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@\u00a2\u0006\u0002\u0010-J\u001c\u0010.\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010H\u0086@\u00a2\u0006\u0002\u0010-J\u0016\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u00102J\u0016\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u00105J\u0016\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u00108J\u0016\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020$H\u0086@\u00a2\u0006\u0002\u0010;J\u001c\u0010<\u001a\u00020+2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H\u0086@\u00a2\u0006\u0002\u0010-J\u000e\u0010>\u001a\u00020+H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010?\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/rpgclicker/data/repository/GameRepository;", "", "database", "Lcom/rpgclicker/data/local/GameDatabase;", "context", "Landroid/content/Context;", "(Lcom/rpgclicker/data/local/GameDatabase;Landroid/content/Context;)V", "dao", "Lcom/rpgclicker/data/local/GameDao;", "json", "Lkotlinx/serialization/json/Json;", "deserializeGameState", "Lcom/rpgclicker/domain/model/GameState;", "entity", "Lcom/rpgclicker/data/local/GameStateEntity;", "getAllAreas", "", "Lcom/rpgclicker/domain/model/Area;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUpgrades", "Lcom/rpgclicker/domain/model/Upgrade;", "getAllUpgradesFlow", "Lkotlinx/coroutines/flow/Flow;", "getArea", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnemiesByArea", "Lcom/rpgclicker/domain/model/Enemy;", "areaId", "getEnemy", "getPrestige", "Lcom/rpgclicker/domain/model/Prestige;", "getSettings", "Lcom/rpgclicker/domain/model/GameSettings;", "getStatistics", "Lcom/rpgclicker/domain/model/GameStatistics;", "getUpgrade", "loadGameState", "observeGameState", "readAsset", "name", "saveAreas", "", "areas", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveEnemies", "enemies", "saveGameState", "state", "(Lcom/rpgclicker/domain/model/GameState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePrestige", "prestige", "(Lcom/rpgclicker/domain/model/Prestige;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSettings", "settings", "(Lcom/rpgclicker/domain/model/GameSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveStatistics", "stats", "(Lcom/rpgclicker/domain/model/GameStatistics;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUpgrades", "upgrades", "seedIfNeeded", "serializeGameState", "app_debug"})
public final class GameRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.data.local.GameDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.data.local.GameDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.serialization.json.Json json = null;
    
    public GameRepository(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.data.local.GameDatabase database, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object seedIfNeeded(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.String readAsset(java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.rpgclicker.domain.model.GameState> observeGameState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveGameState(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameState state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Estado salvo, ou um estado novo se nada foi salvo ainda.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loadGameState(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.model.GameState> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEnemy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.model.Enemy> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEnemiesByArea(@org.jetbrains.annotations.NotNull()
    java.lang.String areaId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.rpgclicker.domain.model.Enemy>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveEnemies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.rpgclicker.domain.model.Enemy> enemies, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getArea(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.model.Area> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllAreas(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.rpgclicker.domain.model.Area>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveAreas(@org.jetbrains.annotations.NotNull()
    java.util.List<com.rpgclicker.domain.model.Area> areas, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUpgrade(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.model.Upgrade> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllUpgrades(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.rpgclicker.domain.model.Upgrade>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveUpgrades(@org.jetbrains.annotations.NotNull()
    java.util.List<com.rpgclicker.domain.model.Upgrade> upgrades, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.rpgclicker.domain.model.Upgrade>> getAllUpgradesFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPrestige(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.model.Prestige> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object savePrestige(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.Prestige prestige, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.model.GameSettings> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveSettings(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStatistics(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.model.GameStatistics> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveStatistics(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameStatistics stats, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.rpgclicker.data.local.GameStateEntity serializeGameState(com.rpgclicker.domain.model.GameState state) {
        return null;
    }
    
    private final com.rpgclicker.domain.model.GameState deserializeGameState(com.rpgclicker.data.local.GameStateEntity entity) {
        return null;
    }
}