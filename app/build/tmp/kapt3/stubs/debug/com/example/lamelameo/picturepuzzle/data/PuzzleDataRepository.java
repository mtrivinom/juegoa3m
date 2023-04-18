package com.example.lamelameo.picturepuzzle.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0019\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/PuzzleDataRepository;", "", "bestDao", "Lcom/example/lamelameo/picturepuzzle/data/BestDataDao;", "(Lcom/example/lamelameo/picturepuzzle/data/BestDataDao;)V", "addBest", "", "data", "Lcom/example/lamelameo/picturepuzzle/data/BestData;", "(Lcom/example/lamelameo/picturepuzzle/data/BestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addBests", "list", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "getBest", "puzzleName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrievePhotoPaths", "", "picDirectory", "Ljava/io/File;", "update", "app_debug"})
public final class PuzzleDataRepository {
    private final com.example.lamelameo.picturepuzzle.data.BestDataDao bestDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> retrievePhotoPaths(@org.jetbrains.annotations.Nullable()
    java.io.File picDirectory) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addBest(@org.jetbrains.annotations.NotNull()
    com.example.lamelameo.picturepuzzle.data.BestData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addBests(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.lamelameo.picturepuzzle.data.BestData> list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBest(@org.jetbrains.annotations.NotNull()
    java.lang.String puzzleName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.lamelameo.picturepuzzle.data.BestData> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.example.lamelameo.picturepuzzle.data.BestData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.lamelameo.picturepuzzle.data.BestData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public PuzzleDataRepository(@org.jetbrains.annotations.NotNull()
    com.example.lamelameo.picturepuzzle.data.BestDataDao bestDao) {
        super();
    }
}