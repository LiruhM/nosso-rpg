package com.rpgclicker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/rpgclicker/RpgClickerApplication;", "Landroid/app/Application;", "()V", "<set-?>", "Lcom/rpgclicker/data/local/GameDatabase;", "gameDatabase", "getGameDatabase", "()Lcom/rpgclicker/data/local/GameDatabase;", "getGameDao", "Lcom/rpgclicker/data/local/GameDao;", "onCreate", "", "app_debug"})
public final class RpgClickerApplication extends android.app.Application {
    @org.jetbrains.annotations.Nullable()
    private com.rpgclicker.data.local.GameDatabase gameDatabase;
    
    public RpgClickerApplication() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.rpgclicker.data.local.GameDatabase getGameDatabase() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.data.local.GameDao getGameDao() {
        return null;
    }
}