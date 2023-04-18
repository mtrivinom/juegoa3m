// Generated by view binder compiler. Do not edit!
package com.example.lamelameo.picturepuzzle.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.lamelameo.picturepuzzle.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ImagePreviewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatImageView previewImage;

  @NonNull
  public final ConstraintLayout previewLayout;

  private ImagePreviewBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatImageView previewImage, @NonNull ConstraintLayout previewLayout) {
    this.rootView = rootView;
    this.previewImage = previewImage;
    this.previewLayout = previewLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ImagePreviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ImagePreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.image_preview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ImagePreviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.previewImage;
      AppCompatImageView previewImage = rootView.findViewById(id);
      if (previewImage == null) {
        break missingId;
      }

      ConstraintLayout previewLayout = (ConstraintLayout) rootView;

      return new ImagePreviewBinding((ConstraintLayout) rootView, previewImage, previewLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}