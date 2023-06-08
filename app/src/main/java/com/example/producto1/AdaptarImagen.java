package com.example.producto1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//Librerias para Firebase y Glide
import com.google.firebase.storage.StorageReference;



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
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.grid_element, null);
        }

        final ImageView imageView = convertView.findViewById(R.id.gridImageview);
        imageView.setImageBitmap(null);
        imageView.post(new Runnable(){
            @SuppressLint("StaticFieldLeak")
            @Override
            public void run(){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
                    new AsyncTask<Void, Void, Void>(){
                        private Bitmap bitmap;
                        @Override
                        protected Void doInBackground(Void... voids){
                            bitmap = getPicFromAsset(imageView, files[position]);
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            imageView.setImageBitmap(bitmap);
                        }
                    }.execute();
                }
            }
        });

        return convertView;
    }

    /* ORIGINAL
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.grid_element, null);
        }

        final ImageView imageView = convertView.findViewById(R.id.gridImageview);
        imageView.setImageBitmap(null);
        imageView.post(new Runnable(){
            @SuppressLint("StaticFieldLeak")
            @Override
            public void run(){
                new AsyncTask<Void, Void, Void>(){
                    private Bitmap bitmap;
                    @Override
                    protected Void doInBackground(Void... voids){
                        bitmap = getPicFromAsset(imageView, files[position]);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        imageView.setImageBitmap(bitmap);
                    }
                }.execute();
            }
        });

        return convertView;
    }*/

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
