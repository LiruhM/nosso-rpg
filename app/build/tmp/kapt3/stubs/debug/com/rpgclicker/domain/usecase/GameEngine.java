package com.rpgclicker.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J:\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u000e\u0010 \u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u0018\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0082@\u00a2\u0006\u0002\u0010&J&\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002JH\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020%0\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020%2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020%00H\u0082@\u00a2\u0006\u0002\u00101J\u000e\u00102\u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010\u001cJ\u000e\u00103\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u00020%H\u0086@\u00a2\u0006\u0002\u0010&J\u0006\u00107\u001a\u00020!J\u0006\u00108\u001a\u00020!R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/rpgclicker/domain/usecase/GameEngine;", "", "repository", "Lcom/rpgclicker/data/repository/GameRepository;", "(Lcom/rpgclicker/data/repository/GameRepository;)V", "autoBattleJob", "Lkotlinx/coroutines/Job;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addExperience", "Lcom/rpgclicker/domain/model/Hero;", "hero", "exp", "", "applyDamage", "Lkotlin/Pair;", "Lcom/rpgclicker/domain/model/GameState;", "Lcom/rpgclicker/domain/usecase/AttackResult;", "state", "damage", "isCrit", "", "isClick", "(Lcom/rpgclicker/domain/model/GameState;IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyOfflineProgress", "Lcom/rpgclicker/domain/usecase/OfflineProgress;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateOfflineProgress", "doPrestige", "Lcom/rpgclicker/domain/usecase/PrestigeResult;", "ensureInitialState", "", "firstEnemyOf", "Lcom/rpgclicker/domain/model/Enemy;", "areaId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "highestArea", "current", "candidate", "areas", "", "Lcom/rpgclicker/domain/model/Area;", "nextEnemyAfter", "defeatedId", "unlocked", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAutoAttack", "onTapAttack", "purchaseUpgrade", "Lcom/rpgclicker/domain/usecase/PurchaseResult;", "upgradeId", "startAutoBattle", "stopAutoBattle", "Companion", "app_debug"})
public final class GameEngine {
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.data.repository.GameRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job autoBattleJob;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.sync.Mutex mutex = null;
    private static final long MAX_OFFLINE_MINUTES = 480L;
    @org.jetbrains.annotations.NotNull()
    public static final com.rpgclicker.domain.usecase.GameEngine.Companion Companion = null;
    
    public GameEngine(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.data.repository.GameRepository repository) {
        super();
    }
    
    /**
     * Garante dados iniciais (seed) e um inimigo ativo.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object ensureInitialState(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onTapAttack(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.usecase.AttackResult> $completion) {
        return null;
    }
    
    /**
     * Ataque automatico: dano = autoDps por segundo.
     */
    private final java.lang.Object onAutoAttack(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object applyDamage(com.rpgclicker.domain.model.GameState state, int damage, boolean isCrit, boolean isClick, kotlin.coroutines.Continuation<? super kotlin.Pair<com.rpgclicker.domain.model.GameState, com.rpgclicker.domain.usecase.AttackResult>> $completion) {
        return null;
    }
    
    private final java.lang.String highestArea(java.lang.String current, java.lang.String candidate, java.util.List<com.rpgclicker.domain.model.Area> areas) {
        return null;
    }
    
    private final java.lang.Object firstEnemyOf(java.lang.String areaId, kotlin.coroutines.Continuation<? super com.rpgclicker.domain.model.Enemy> $completion) {
        return null;
    }
    
    private final java.lang.Object nextEnemyAfter(java.lang.String areaId, java.lang.String defeatedId, java.util.List<com.rpgclicker.domain.model.Area> areas, java.util.Set<java.lang.String> unlocked, kotlin.coroutines.Continuation<? super kotlin.Pair<com.rpgclicker.domain.model.Enemy, java.lang.String>> $completion) {
        return null;
    }
    
    /**
     * Aplica XP e sobe de nivel quantas vezes for preciso.
     */
    private final com.rpgclicker.domain.model.Hero addExperience(com.rpgclicker.domain.model.Hero hero, int exp) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object purchaseUpgrade(@org.jetbrains.annotations.NotNull()
    java.lang.String upgradeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.usecase.PurchaseResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object doPrestige(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.usecase.PrestigeResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.usecase.OfflineProgress calculateOfflineProgress(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameState state) {
        return null;
    }
    
    /**
     * Calcula e aplica o progresso offline; devolve o que foi ganho.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object applyOfflineProgress(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rpgclicker.domain.usecase.OfflineProgress> $completion) {
        return null;
    }
    
    public final void startAutoBattle() {
    }
    
    public final void stopAutoBattle() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/rpgclicker/domain/usecase/GameEngine$Companion;", "", "()V", "MAX_OFFLINE_MINUTES", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}