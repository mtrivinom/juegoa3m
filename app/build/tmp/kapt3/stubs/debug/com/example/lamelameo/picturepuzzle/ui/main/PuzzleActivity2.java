package com.example.lamelameo.picturepuzzle.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u000eH\u0014J\b\u0010\u001e\u001a\u00020\u000eH\u0014J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\u0016\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013J\u0017\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0002\u0010&J\u0017\u0010\'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/ui/main/PuzzleActivity2;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "mBinding", "Lcom/example/lamelameo/picturepuzzle/databinding/Puzzle2ActivityBinding;", "mHandler", "Landroid/os/Handler;", "mPauseFragment", "Landroidx/fragment/app/Fragment;", "mViewModel", "Lcom/example/lamelameo/picturepuzzle/data/MainViewModel;", "closePauseUI", "", "createPuzzleCells", "gridLayout", "Landroidx/gridlayout/widget/GridLayout;", "numRows", "", "handleResume", "loadBestsView", "puzzleBests", "", "newToast", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "openPauseUI", "openSolvedUI", "swapCellImages", "index1", "index2", "updateMovesView", "moves", "(Ljava/lang/Integer;)V", "updateTimerView", "time", "app_debug"})
public final class PuzzleActivity2 extends androidx.appcompat.app.AppCompatActivity {
    private com.example.lamelameo.picturepuzzle.data.MainViewModel mViewModel;
    private android.os.Handler mHandler;
    private com.example.lamelameo.picturepuzzle.databinding.Puzzle2ActivityBinding mBinding;
    private androidx.fragment.app.Fragment mPauseFragment;
    private final java.lang.String TAG = "PuzzleActivity2";
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void openSolvedUI() {
    }
    
    private final void newToast() {
    }
    
    private final void openPauseUI() {
    }
    
    private final void closePauseUI() {
    }
    
    private final void createPuzzleCells(androidx.gridlayout.widget.GridLayout gridLayout, int numRows) {
    }
    
    private final void handleResume() {
    }
    
    private final void loadBestsView(java.util.List<java.lang.Integer> puzzleBests) {
    }
    
    private final void updateMovesView(java.lang.Integer moves) {
    }
    
    private final void updateTimerView(java.lang.Integer time) {
    }
    
    public final void swapCellImages(int index1, int index2) {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public PuzzleActivity2() {
        super();
    }
}