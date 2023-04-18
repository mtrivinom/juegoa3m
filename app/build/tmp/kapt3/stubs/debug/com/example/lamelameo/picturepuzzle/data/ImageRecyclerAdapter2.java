package com.example.lamelameo.picturepuzzle.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B-\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0004J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0006\u0010\u0014\u001a\u00020\u0005J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\bH\u0002R\u000e\u0010\f\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/ImageRecyclerAdapter2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/lamelameo/picturepuzzle/data/ImageRecyclerAdapter2$MyViewHolder;", "mDrawableInts", "", "", "mPhotoPaths", "", "", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Ljava/util/List;Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView;)V", "TAG", "selectedImage", "viewHolderListener", "Landroid/view/View$OnClickListener;", "addPhotos", "", "newPaths", "getItemCount", "getSelection", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "onViewAttachedToWindow", "scalePhoto", "Landroid/graphics/Bitmap;", "viewSize", "photoPath", "MyViewHolder", "app_debug"})
public final class ImageRecyclerAdapter2 extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.lamelameo.picturepuzzle.data.ImageRecyclerAdapter2.MyViewHolder> {
    private final java.lang.String TAG = "ImageRecyclerAdapter2";
    private int selectedImage = -1;
    private final android.view.View.OnClickListener viewHolderListener = null;
    private final java.util.List<java.lang.Integer> mDrawableInts = null;
    private final java.util.List<java.lang.String> mPhotoPaths = null;
    private final androidx.recyclerview.widget.RecyclerView mRecyclerView = null;
    
    public final int getSelection() {
        return 0;
    }
    
    @java.lang.Override()
    public void onViewAttachedToWindow(@org.jetbrains.annotations.NotNull()
    com.example.lamelameo.picturepuzzle.data.ImageRecyclerAdapter2.MyViewHolder holder) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.lamelameo.picturepuzzle.data.ImageRecyclerAdapter2.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int i) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.lamelameo.picturepuzzle.data.ImageRecyclerAdapter2.MyViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void addPhotos(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> newPaths) {
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
    
    public ImageRecyclerAdapter2(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> mDrawableInts, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> mPhotoPaths, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView mRecyclerView) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/data/ImageRecyclerAdapter2$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mPreviewLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "(Landroidx/constraintlayout/widget/ConstraintLayout;Landroidx/appcompat/widget/AppCompatImageView;)V", "getMImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "getMPreviewLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final androidx.constraintlayout.widget.ConstraintLayout mPreviewLayout = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.appcompat.widget.AppCompatImageView mImageView = null;
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.constraintlayout.widget.ConstraintLayout getMPreviewLayout() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatImageView getMImageView() {
            return null;
        }
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
        androidx.constraintlayout.widget.ConstraintLayout mPreviewLayout, @org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.AppCompatImageView mImageView) {
            super(null);
        }
    }
}