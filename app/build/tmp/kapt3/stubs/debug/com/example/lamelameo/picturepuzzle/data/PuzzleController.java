package com.example.lamelameo.picturepuzzle.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J*\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007J*\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007J\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u00172\u0006\u0010\u0018\u001a\u00020\u0007J \u0010\u0019\u001a\u00020\u00072\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u0017H\u0002J \u0010\u001b\u001a\u00020\u001c2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/PuzzleController;", "", "handler", "Landroid/os/Handler;", "puzzleData", "Lcom/example/lamelameo/picturepuzzle/data/PuzzleData;", "numCols", "", "(Landroid/os/Handler;Lcom/example/lamelameo/picturepuzzle/data/PuzzleData;I)V", "TAG", "", "maps", "", "numCorrect", "numMoves", "cellClick", "cellIndex", "emptyIndex", "cellSwipe", "direction", "cellSwipeSimple", "generatePuzzle", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "gridSize", "getInversions", "list", "gridSolved", "", "swapCells", "", "cell1", "cell2", "app_debug"})
public final class PuzzleController {
    private int numCorrect = 0;
    private int numMoves = 0;
    private final java.lang.String TAG = "PuzzleController";
    private final java.util.List<java.util.List<java.lang.Integer>> maps = null;
    private android.os.Handler handler;
    private com.example.lamelameo.picturepuzzle.data.PuzzleData puzzleData;
    private final int numCols = 0;
    
    /**
     * Populate a list with cell position indexes in a random order. This order of cells is checked for a property
     * which tells us if the puzzle can be solved. If it cannot be solved, we simply have to swap two items to make it
     * solvable. Once solvable, we return the ArrayList.
     *
     * @param gridSize number of cells in the puzzle grid
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> generatePuzzle(int gridSize) {
        return null;
    }
    
    /**
     * Given an ordered list of integers, determine the number of pairs (a,b) where a > b and index a < index b
     * @param list input list of integers
     */
    private final int getInversions(java.util.ArrayList<java.lang.Integer> list) {
        return 0;
    }
    
    /**
     */
    private final void swapCells(int cell1, int cell2) {
    }
    
    /**
     * Determine if grid is solved by iterating through the puzzleState list and checking that the index matches the
     * cell index at that position
     *
     * @return a boolean which indicates whether the grid is solved or not
     */
    private final boolean gridSolved(java.util.ArrayList<java.lang.Integer> list) {
        return false;
    }
    
    /**
     * Given the index of a cell that has been clicked, determine if it should be moved by
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> cellClick(int cellIndex, int emptyIndex) {
        return null;
    }
    
    /**
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.lang.Integer>> cellSwipe(int cellIndex, int emptyIndex, int direction) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.lang.Integer>> cellSwipeSimple(int cellIndex, int emptyIndex, int direction) {
        return null;
    }
    
    public PuzzleController(@org.jetbrains.annotations.NotNull()
    android.os.Handler handler, @org.jetbrains.annotations.NotNull()
    com.example.lamelameo.picturepuzzle.data.PuzzleData puzzleData, int numCols) {
        super();
    }
}