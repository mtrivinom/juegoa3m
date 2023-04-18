package com.example.lamelameo.picturepuzzle.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0003H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/ImageController;", "", "imagePath", "", "imageBitmap", "Landroid/graphics/Bitmap;", "gridSize", "", "numRows", "(Ljava/lang/String;Landroid/graphics/Bitmap;II)V", "TAG", "mCellImages", "", "mImage", "createCellBitmaps", "bmp", "rows", "getCellBitmap", "index", "getImageBitmap", "scalePhoto", "viewSize", "photoPath", "app_debug"})
public final class ImageController {
    private final android.graphics.Bitmap mImage = null;
    private java.util.List<android.graphics.Bitmap> mCellImages;
    private final java.lang.String TAG = "ImageController";
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getImageBitmap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap getCellBitmap(int index) {
        return null;
    }
    
    /**
     * Scale an image from a file path to a specific views size, and return as a Bitmap
     * Intended to be used for photos taken with a camera intent so images are by default in landscape
     * Therefore images are also rotated 90 degrees
     *
     * @param viewSize  size of the (pixels) view that the image is intended to be placed into
     * @param photoPath file path of the image to be scaled
     * @return the scaled and rotated image as a Bitmap object
     */
    private final android.graphics.Bitmap scalePhoto(int viewSize, java.lang.String photoPath) {
        return null;
    }
    
    /**
     * create the grid of smaller cell bitmaps using the chosen image and grid size and add them to the bitmaps list
     *
     * @param bmp     bitmap image to be used to create grid of images for the puzzle
     * @param rows    number of rows to split the grid into
     */
    private final java.util.List<android.graphics.Bitmap> createCellBitmaps(android.graphics.Bitmap bmp, int rows) {
        return null;
    }
    
    public ImageController(@org.jetbrains.annotations.Nullable()
    java.lang.String imagePath, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap imageBitmap, int gridSize, int numRows) {
        super();
    }
}