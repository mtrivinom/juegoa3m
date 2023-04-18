package com.example.lamelameo.picturepuzzle.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0015J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00040\u00040\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/lamelameo/picturepuzzle/ui/main/MainActivity2;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "defaultAdapterActive", "", "defaultPuzzles", "", "drawableInts", "", "", "mBinding", "Lcom/example/lamelameo/picturepuzzle/databinding/ActivityMainBinding;", "mGalleryPaths", "", "mGridRows", "mPermission", "mPhotoAdapter", "Lcom/example/lamelameo/picturepuzzle/data/ImageRecyclerAdapter2;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "retrieveGalleryPhotos", "paths", "showRationale", "permission", "app_debug"})
public final class MainActivity2 extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String TAG = "MainActivity2_";
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private int mGridRows = 4;
    private boolean defaultAdapterActive = true;
    private com.example.lamelameo.picturepuzzle.data.ImageRecyclerAdapter2 mPhotoAdapter;
    private com.example.lamelameo.picturepuzzle.databinding.ActivityMainBinding mBinding;
    private final java.util.List<java.lang.Integer> drawableInts = null;
    private final int[] defaultPuzzles = {2131165307, 2131165304, 2131165305, 2131165306};
    private final java.lang.String mPermission = "android.permission.READ_EXTERNAL_STORAGE";
    private final java.util.List<java.lang.String> mGalleryPaths = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermissionLauncher = null;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showRationale(java.lang.String permission) {
    }
    
    private final java.util.List<java.lang.String> retrieveGalleryPhotos(java.util.List<java.lang.String> paths) {
        return null;
    }
    
    public MainActivity2() {
        super();
    }
}