package com.example.lamelameo.picturepuzzle.data;

import java.lang.System;

@androidx.room.Database(entities = {com.example.lamelameo.picturepuzzle.data.BestData.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u0000 \b2\u00020\u0001:\u0002\u0007\bB\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/BestsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "bestDao", "Lcom/example/lamelameo/picturepuzzle/data/BestDataDao;", "getBestDao", "()Lcom/example/lamelameo/picturepuzzle/data/BestDataDao;", "BestDatabaseCallback", "Companion", "app_debug"})
public abstract class BestsDatabase extends androidx.room.RoomDatabase {
    private static volatile com.example.lamelameo.picturepuzzle.data.BestsDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.lamelameo.picturepuzzle.data.BestsDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.lamelameo.picturepuzzle.data.BestDataDao getBestDao();
    
    public BestsDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/BestsDatabase$BestDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "data", "", "", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/List;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_debug"})
    static final class BestDatabaseCallback extends androidx.room.RoomDatabase.Callback {
        private final kotlinx.coroutines.CoroutineScope scope = null;
        private final java.util.List<java.lang.Integer> data = null;
        
        @java.lang.Override()
        public void onCreate(@org.jetbrains.annotations.NotNull()
        androidx.sqlite.db.SupportSQLiteDatabase db) {
        }
        
        public BestDatabaseCallback(@org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.Integer> data) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/BestsDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/lamelameo/picturepuzzle/data/BestsDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.lamelameo.picturepuzzle.data.BestsDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}