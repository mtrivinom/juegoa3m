package com.example.lamelameo.picturepuzzle.ui.main;

import java.lang.System;

/**
 * TODO: document your custom view class.
 */
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J(\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0017H\u0002J*\u0010%\u001a\u00020&2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\'\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020(H\u0016R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/ui/main/PuzzleCellView2;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "viewModel", "Lcom/example/lamelameo/picturepuzzle/data/MainViewModel;", "(Landroid/content/Context;Lcom/example/lamelameo/picturepuzzle/data/MainViewModel;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DISTANCE_THRESHOLD", "TAG", "", "VELOCITY_THRESHOLD", "mContext", "Lcom/example/lamelameo/picturepuzzle/ui/main/PuzzleActivity2;", "mVelocityTracker", "Landroid/view/VelocityTracker;", "mainViewModel", "xDown", "", "yDown", "analyseEventForGesture", "event", "Landroid/view/MotionEvent;", "action", "pointerId", "determineGesture", "xVelocity", "xDiff", "yVelocity", "yDiff", "dpToPx", "dp", "init", "", "onTouchEvent", "", "performClick", "app_debug"})
public final class PuzzleCellView2 extends androidx.appcompat.widget.AppCompatImageView {
    private android.view.VelocityTracker mVelocityTracker;
    private final java.lang.String TAG = "PuzzleCellView";
    private float xDown = 0.0F;
    private float yDown = 0.0F;
    private com.example.lamelameo.picturepuzzle.ui.main.PuzzleActivity2 mContext;
    private com.example.lamelameo.picturepuzzle.data.MainViewModel mainViewModel;
    private int DISTANCE_THRESHOLD = 0;
    private int VELOCITY_THRESHOLD = 0;
    
    private final void init(android.util.AttributeSet attrs, int defStyle, android.content.Context context, com.example.lamelameo.picturepuzzle.data.MainViewModel viewModel) {
    }
    
    /**
     * convert density independent pixels to pixels using the device's pixel density
     *
     * @param dp amount to be converted from dp to px
     * @return the value converted to units of pixels as an integer (rounds up or down)
     */
    private final int dpToPx(float dp) {
        return 0;
    }
    
    /**
     * Handle simple touch events as either a swipe (up/down/left/right) or a click - multi touch is not supported.
     * Swipe direction is determined by distance travelled in the x/y planes between touch/release and its release velocity.
     * Distance and velocity must be greater than DISTANCE_THRESHOLD and VELOCITY_THRESHOLD, respectively, to be valid.
     * An event that doesn't fit any of the set criteria is considered a click and handed to the onClick listener.
     */
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    private final int analyseEventForGesture(android.view.MotionEvent event, int action, int pointerId) {
        return 0;
    }
    
    /**
     * Determine the gesture given the relevant velocity and distances. If satisfied with distance and velocity we
     * call SwipeCell() from the PuzzleActivity context, else we call [.performClick] instead.
     *
     * @param xVelocity velocity in x direction
     * @param xDiff     distance in x direction
     * @param yVelocity velocity in y direction
     * @param yDiff     distance in y direction
     */
    private final int determineGesture(float xVelocity, float xDiff, float yVelocity, float yDiff) {
        return 0;
    }
    
    /**
     * Handle single clicks on any cell other than the empty cell - these are filtered out in the touchListener.
     * Checks if the clicked cell is a direct neighbour of the empty cell.
     * If so then calls PuzzleActivity.MoveCells to handle movement of images/tags and checking if grid is solved.
     */
    @java.lang.Override()
    public boolean performClick() {
        return false;
    }
    
    public PuzzleCellView2(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.lamelameo.picturepuzzle.data.MainViewModel viewModel) {
        super(null);
    }
    
    public PuzzleCellView2(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public PuzzleCellView2(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs, int defStyle) {
        super(null);
    }
}