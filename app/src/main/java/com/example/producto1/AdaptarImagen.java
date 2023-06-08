package com.example.producto1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//Librerias para Firebase y Glide
import com.bumptech.glide.Glide;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.request.RequestListener;
import androidx.annotation.Nullable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;
import android.util.Log;


public class AdaptarImagen extends BaseAdapter {
    private final List<StorageReference> imageRefs;
    private final Context context;
    private Context mContext;
    private AssetManager assetmanager;

    private String[] files;
    private MainActivity mainActivity;

    public AdaptarImagen(MainActivity mainActivity, List<StorageReference> imageRefs) {
        this.mainActivity = mainActivity;
        this.context = mainActivity.getApplicationContext();
        this.imageRefs = imageRefs;
    }

    @Override
    public int getCount() {
        if (imageRefs != null) {
            return imageRefs.size();
        } else {
            return 0;
        }
    }

    public Object getItem(int position){return null;}

    public long getItemId(int position){return 0;}

    //crea una nueva ImageView por cada objecto referenciado por el adaptador
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.grid_element, null);
        }

        final ImageView imageView = convertView.findViewById(R.id.gridImageview);
        imageView.setImageBitmap(null);

        // Obtener la referencia a la imagen en Firebase Storage
        StorageReference imageRef = imageRefs.get(position % imageRefs.size());

        // Descargar la imagen y cargarla en el ImageView utilizando Glide
        Glide.with(context)
                .asBitmap()
                .load(imageRef)
                .listener(new RequestListener<Bitmap>() { //NO SE YA QUE HACER CONTIGO!!!!
                    @Override
                    public boolean onLoadFailed(@Nullable Exception e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        Log.d("ImageLoad", "Failed to load image: " + imageRef.getName());
                        return false;
                    }

                    //@Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d("ImageLoad", "Image loaded successfully: " + imageRef.getName());
                        return false;
                    }
                })
                .into(imageView);

        return convertView;
    }


    private Bitmap getPicFromAsset(ImageView imageView, String assetName) {
        //Coger las dimensiones de la View
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

        if(targetW == 0 || targetH == 0) {
            return null;
        }
        try{
            InputStream inputStream = assetmanager.open("img/" + assetName);
            //Coger las dimensiones del bitmap
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, new Rect(-1, -1, -1, -1), bmOptions);
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;

            //Determinar cuando necesita escalar la imagen
            int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

            inputStream.reset();

            //Pasar la imagen a Bitmap para que encage con la view
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;


            return BitmapFactory.decodeStream(inputStream, new Rect(-1,-1,-1,-1), bmOptions);
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

}
