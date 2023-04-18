package com.example.lamelameo.picturepuzzle.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/Ticker;", "", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "isRunning", "", "tickElapsed", "", "tickStartTime", "timerExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "timerFuture", "Ljava/util/concurrent/ScheduledFuture;", "timerRunnable", "Ljava/lang/Runnable;", "getTickElapsed", "pauseTimer", "", "setTickElapsed", "num", "startTimer", "app_debug"})
public final class Ticker {
    private long tickStartTime;
    private long tickElapsed = 0L;
    private final java.util.concurrent.ScheduledThreadPoolExecutor timerExecutor = null;
    private java.util.concurrent.ScheduledFuture<?> timerFuture;
    private boolean isRunning = false;
    private java.lang.Runnable timerRunnable;
    private android.os.Handler handler;
    
    /**
     * A method to post a delayed runnable task every 1000 ms which handles timer ticks.
     * ScheduledThreadPoolExecutor is used to schedule a runnable in an indefinite sequence which is cancelled upon
     * game pause or finish. Game pauses mid tick are handled by a delay which is calculated using {@link #tickElapsed}
     * which every call of {@link #pauseTimer()} which resets every tick completion.
     */
    public final void startTimer() {
    }
    
    /**
     * Method to pause the game timer by cancelling the ScheduledThreadPoolExecutor which handles scheduling runnables
     * responsible for incrementing the timer and updating the TextView. The time elapsed since the previous tick is
     * calculated and stored as {@link #tickElapsed} which can be used to determine the appropriate delay for the timer
     * once resumed, thus keeping the timer accurate. This is calculated from the system time at the previous tick
     * stored in {@link #tickStartTime} each clock tick and the current system time upon call.
     */
    public final void pauseTimer() {
    }
    
    /**
     * Setter function for tickElapsed variable to be accessed from ViewModel after UI has undergone a state change.
     */
    public final void setTickElapsed(long num) {
    }
    
    /**
     * Getter function for tickElapsed variable to be accessed from ViewModel after UI has undergone a state change.
     */
    public final long getTickElapsed() {
        return 0L;
    }
    
    public final boolean isRunning() {
        return false;
    }
    
    public Ticker(@org.jetbrains.annotations.NotNull()
    android.os.Handler handler) {
        super();
    }
}