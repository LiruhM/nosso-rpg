package com.rpgclicker.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\b\u0010\"\u001a\u00020\u001fH\u0002J\u0006\u0010#\u001a\u00020\u001fJ\b\u0010$\u001a\u00020\u001fH\u0014J\u0006\u0010%\u001a\u00020\u001fJ\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u001fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/rpgclicker/presentation/viewmodel/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/rpgclicker/data/repository/GameRepository;", "gameEngine", "Lcom/rpgclicker/domain/usecase/GameEngine;", "(Lcom/rpgclicker/data/repository/GameRepository;Lcom/rpgclicker/domain/usecase/GameEngine;)V", "_autoBattleEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_gameState", "Lcom/rpgclicker/domain/model/GameState;", "_lastAttackResult", "Lcom/rpgclicker/domain/usecase/AttackResult;", "_offlineProgress", "Lcom/rpgclicker/domain/usecase/OfflineProgress;", "autoBattleEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "getAutoBattleEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "gameState", "getGameState", "lastAttackResult", "getLastAttackResult", "offlineProgress", "getOfflineProgress", "upgrades", "", "Lcom/rpgclicker/domain/model/Upgrade;", "getUpgrades", "dismissAttackResult", "", "dismissOfflineProgress", "doPrestige", "loadGame", "onAppForeground", "onCleared", "onTapAttack", "purchaseUpgrade", "upgradeId", "", "toggleAutoBattle", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.data.repository.GameRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.domain.usecase.GameEngine gameEngine = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.rpgclicker.domain.model.GameState> _gameState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.rpgclicker.domain.model.GameState> gameState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.rpgclicker.domain.model.Upgrade>> upgrades = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.rpgclicker.domain.usecase.AttackResult> _lastAttackResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.rpgclicker.domain.usecase.AttackResult> lastAttackResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.rpgclicker.domain.usecase.OfflineProgress> _offlineProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.rpgclicker.domain.usecase.OfflineProgress> offlineProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _autoBattleEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> autoBattleEnabled = null;
    
    public GameViewModel(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.data.repository.GameRepository repository, @org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.usecase.GameEngine gameEngine) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.rpgclicker.domain.model.GameState> getGameState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.rpgclicker.domain.model.Upgrade>> getUpgrades() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.rpgclicker.domain.usecase.AttackResult> getLastAttackResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.rpgclicker.domain.usecase.OfflineProgress> getOfflineProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getAutoBattleEnabled() {
        return null;
    }
    
    private final void loadGame() {
    }
    
    public final void onTapAttack() {
    }
    
    public final void purchaseUpgrade(@org.jetbrains.annotations.NotNull()
    java.lang.String upgradeId) {
    }
    
    public final void doPrestige() {
    }
    
    public final void toggleAutoBattle() {
    }
    
    public final void onAppForeground() {
    }
    
    public final void dismissOfflineProgress() {
    }
    
    public final void dismissAttackResult() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}