package com.rpgclicker.domain.model;

@kotlinx.serialization.Serializable()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0002JKB\u008d\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010\u001aB}\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u001bJ\u0006\u00100\u001a\u000201J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0017H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\tH\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u00c6\u0003J\u0015\u00107\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\rH\u00c6\u0003J\t\u00108\u001a\u00020\u000fH\u00c6\u0003J\t\u00109\u001a\u00020\u0011H\u00c6\u0003J\t\u0010:\u001a\u00020\u0013H\u00c6\u0003J\t\u0010;\u001a\u00020\u0015H\u00c6\u0003J\u0081\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u00c6\u0001J\u0006\u0010=\u001a\u00020\u0003J\u0013\u0010>\u001a\u0002012\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010@\u001a\u00020\u0003H\u00d6\u0001J\t\u0010A\u001a\u00020\tH\u00d6\u0001J&\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u00c1\u0001\u00a2\u0006\u0002\bIR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\r\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/\u00a8\u0006L"}, d2 = {"Lcom/rpgclicker/domain/model/GameState;", "", "seen1", "", "hero", "Lcom/rpgclicker/domain/model/Hero;", "currentEnemy", "Lcom/rpgclicker/domain/model/Enemy;", "currentAreaId", "", "unlockedAreas", "", "purchasedUpgrades", "", "prestige", "Lcom/rpgclicker/domain/model/Prestige;", "lastSaved", "Lkotlinx/datetime/Instant;", "totalPlayTime", "", "settings", "Lcom/rpgclicker/domain/model/GameSettings;", "statistics", "Lcom/rpgclicker/domain/model/GameStatistics;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/rpgclicker/domain/model/Hero;Lcom/rpgclicker/domain/model/Enemy;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Lcom/rpgclicker/domain/model/Prestige;Lkotlinx/datetime/Instant;JLcom/rpgclicker/domain/model/GameSettings;Lcom/rpgclicker/domain/model/GameStatistics;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/rpgclicker/domain/model/Hero;Lcom/rpgclicker/domain/model/Enemy;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Lcom/rpgclicker/domain/model/Prestige;Lkotlinx/datetime/Instant;JLcom/rpgclicker/domain/model/GameSettings;Lcom/rpgclicker/domain/model/GameStatistics;)V", "getCurrentAreaId", "()Ljava/lang/String;", "getCurrentEnemy", "()Lcom/rpgclicker/domain/model/Enemy;", "getHero", "()Lcom/rpgclicker/domain/model/Hero;", "getLastSaved", "()Lkotlinx/datetime/Instant;", "getPrestige", "()Lcom/rpgclicker/domain/model/Prestige;", "getPurchasedUpgrades", "()Ljava/util/Map;", "getSettings", "()Lcom/rpgclicker/domain/model/GameSettings;", "getStatistics", "()Lcom/rpgclicker/domain/model/GameStatistics;", "getTotalPlayTime", "()J", "getUnlockedAreas", "()Ljava/util/Set;", "canPrestige", "", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "crystalsOnPrestige", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
public final class GameState {
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.domain.model.Hero hero = null;
    @org.jetbrains.annotations.Nullable()
    private final com.rpgclicker.domain.model.Enemy currentEnemy = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currentAreaId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> unlockedAreas = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Integer> purchasedUpgrades = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.domain.model.Prestige prestige = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.Instant lastSaved = null;
    private final long totalPlayTime = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.domain.model.GameSettings settings = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rpgclicker.domain.model.GameStatistics statistics = null;
    public static final long PRESTIGE_GOLD_PER_CRYSTAL = 1000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.rpgclicker.domain.model.GameState.Companion Companion = null;
    
    public GameState(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.Hero hero, @org.jetbrains.annotations.Nullable()
    com.rpgclicker.domain.model.Enemy currentEnemy, @org.jetbrains.annotations.NotNull()
    java.lang.String currentAreaId, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> unlockedAreas, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> purchasedUpgrades, @org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.Prestige prestige, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.Instant lastSaved, long totalPlayTime, @org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameSettings settings, @org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameStatistics statistics) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.Hero getHero() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.rpgclicker.domain.model.Enemy getCurrentEnemy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentAreaId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> getUnlockedAreas() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> getPurchasedUpgrades() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.Prestige getPrestige() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.Instant getLastSaved() {
        return null;
    }
    
    public final long getTotalPlayTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.GameSettings getSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.GameStatistics getStatistics() {
        return null;
    }
    
    /**
     * Prestigio liberado quando o heroi tem ao menos 1000 de ouro (1 cristal a cada 1000).
     */
    public final boolean canPrestige() {
        return false;
    }
    
    public final int crystalsOnPrestige() {
        return 0;
    }
    
    public GameState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.Hero component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.GameStatistics component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.rpgclicker.domain.model.Enemy component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.Prestige component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.Instant component7() {
        return null;
    }
    
    public final long component8() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.GameSettings component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rpgclicker.domain.model.GameState copy(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.Hero hero, @org.jetbrains.annotations.Nullable()
    com.rpgclicker.domain.model.Enemy currentEnemy, @org.jetbrains.annotations.NotNull()
    java.lang.String currentAreaId, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> unlockedAreas, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> purchasedUpgrades, @org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.Prestige prestige, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.Instant lastSaved, long totalPlayTime, @org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameSettings settings, @org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameStatistics statistics) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void write$Self$app_debug(@org.jetbrains.annotations.NotNull()
    com.rpgclicker.domain.model.GameState self, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/rpgclicker/domain/model/GameState.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/rpgclicker/domain/model/GameState;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated()
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.rpgclicker.domain.model.GameState> {
        @org.jetbrains.annotations.NotNull()
        public static final com.rpgclicker.domain.model.GameState.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.rpgclicker.domain.model.GameState deserialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override()
        public void serialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull()
        com.rpgclicker.domain.model.GameState value) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/rpgclicker/domain/model/GameState$Companion;", "", "()V", "PRESTIGE_GOLD_PER_CRYSTAL", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/rpgclicker/domain/model/GameState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.serialization.KSerializer<com.rpgclicker.domain.model.GameState> serializer() {
            return null;
        }
    }
}