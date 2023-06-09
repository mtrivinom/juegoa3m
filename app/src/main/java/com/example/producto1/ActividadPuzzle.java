package com.example.producto1;

import static java.lang.Math.abs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ActividadPuzzle extends AppCompatActivity {

    ArrayList<PiezaPuzzle> piezas;

    int counter = 0;

    static long time = 0;

    String Tiempo;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        final RelativeLayout layout = findViewById(R.id.layout);
        final ImageView imageView = findViewById(R.id.imageView);
        final TextView textView = findViewById(R.id.level);
        textView.setText(Integer.toString(counter));

        Intent intent = getIntent();
        final String assetName = intent.getStringExtra("assetName");

        imageView.post(new Runnable() {
            @Override
            public void run() {
                startChronometer();
                if (assetName !=null) {
                    setPicFromAsset(assetName, imageView);
                }
                piezas = splitImage(4 + counter * 2, 2 + counter, 2 + counter); //Dificultad
                TouchListener touchListener = new TouchListener(ActividadPuzzle.this);
                Collections.shuffle(piezas);
                for (PiezaPuzzle pieza : piezas) {
                    pieza.setOnTouchListener(touchListener);
                    layout.addView(pieza);
                    //Aleitorizar la posicion, poniendo todas las piezas abajo de la pantalla
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) pieza.getLayoutParams();
                    lParams.leftMargin = new Random().nextInt(layout.getWidth() - pieza.pieceWidth);
                    lParams.topMargin = layout.getHeight() - pieza.pieceHeight;
                    pieza.setLayoutParams(lParams);
                }
            }
        });

    }

    public void continuar() {
        counter = counter +1; //Nivel
        int longitudFiles;
        setContentView(R.layout.activity_puzzle);

        final RelativeLayout layout = findViewById(R.id.layout);
        final ImageView imageView = findViewById(R.id.imageView);
        final TextView textView = findViewById(R.id.level);
        textView.setText(Integer.toString(counter));

        AssetManager assetManager = getAssets();

        try {
            final String[] files  = assetManager.list("img");
            longitudFiles = files.length;
            int randomNum = ThreadLocalRandom.current().nextInt(0, longitudFiles - 1);
            Intent intent = getIntent();

            final String assetName = files[randomNum];

            imageView.post(new Runnable() {
                @Override
                public void run() {
                    secondChrono();
                    if (assetName != null) {
                        setPicFromAsset(assetName, imageView);
                    }
                    piezas = splitImage(4 + counter * 2, 2 + counter, 2 + counter);

                    TouchListener touchListener = new TouchListener(ActividadPuzzle.this);
                    Collections.shuffle(piezas);
                    for (PiezaPuzzle pieza : piezas) {
                        pieza.setOnTouchListener(touchListener);
                        layout.addView(pieza);
                        //De nuevo, aleitorizar piezas abajo de la pantalla
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) pieza.getLayoutParams();
                        lParams.leftMargin = new Random().nextInt(layout.getWidth() - pieza.pieceWidth);
                        lParams.topMargin = layout.getHeight() - pieza.pieceHeight;
                        pieza.setLayoutParams(lParams);

                    }
                }
            });
        } catch (IOException e){
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setPicFromAsset(String assetName, ImageView imageView){
        //Cogemos dimensiones de la View
        int targetWidth = imageView.getWidth();
        int targetHeight = imageView.getHeight();

        AssetManager assetManager = getAssets();
        try{
            InputStream inputStream = assetManager.open("img/" + assetName);
            //Cogemos dimensiones del bitmap
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, new Rect(-1,-1,-1,-1), bmOptions);
            int photoWidth = bmOptions.outWidth;
            int photoHeight = bmOptions.outHeight;

            int scaleFactor = Math.min(photoWidth / targetWidth, photoHeight / targetHeight);

            inputStream.reset();

            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;

            Bitmap bitmap = BitmapFactory.decodeStream(inputStream, new Rect(-1,-1,-1,-1), bmOptions);
            imageView.setImageBitmap(bitmap);
        } catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<PiezaPuzzle> splitImage(int numPiezas, int filas, int columnas){
        ImageView imageView = findViewById(R.id.imageView);
        ArrayList<PiezaPuzzle> piezas = new ArrayList<>(numPiezas);

        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        //Coger el bitmap escalado de la imagen
        int[] dimensions = getBitmapPositionInsideImageView(imageView);
        int scaledBitmapLeft = dimensions[0];
        int scaledBitmapTop = dimensions[1];
        int scaledBitmapWidth = dimensions[2];
        int scaledBitmapHeight = dimensions[3];

        int croppedImageWidth = scaledBitmapWidth - 2 * abs(scaledBitmapLeft);
        int croppedImageHeight = scaledBitmapHeight - 2 * abs(scaledBitmapTop);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, scaledBitmapWidth, scaledBitmapHeight, true);
        Bitmap croppedBitmap = Bitmap.createBitmap(scaledBitmap, abs(scaledBitmapLeft), abs(scaledBitmapTop), croppedImageWidth, croppedImageHeight);

        //Calcular el ancho y la altura de las piezas
        int anchoPieza = croppedImageWidth / columnas;
        int altoPieza = croppedImageHeight / filas;

        //Crear cada bitmap de las piezas y añadir al Array resultante
        int yCoord = 0;
        for(int fila = 0; fila < filas; fila++){
            int xCoord = 0;
            for(int columna = 0; columna < columnas; columna++){
                int offsetX = 0;
                int offsetY = 0;
                if(columna > 0) {
                    offsetX = anchoPieza / 3;
                }
                if ( fila > 0) {
                    offsetY = altoPieza / 3;
                }

                Bitmap piezaBitmap = Bitmap.createBitmap(croppedBitmap, xCoord - offsetX, yCoord - offsetY, anchoPieza + offsetX, altoPieza + offsetY);
                PiezaPuzzle pieza = new PiezaPuzzle(getApplicationContext());
                pieza.setImageBitmap(piezaBitmap);
                pieza.xCoord = xCoord - offsetX + imageView.getLeft();
                pieza.yCoord = yCoord - offsetY + imageView.getTop();
                pieza.pieceWidth = anchoPieza + offsetX;
                pieza.pieceHeight = altoPieza + offsetY;

                Bitmap piezaPuzzle = Bitmap.createBitmap(anchoPieza + offsetX, altoPieza + offsetY, Bitmap.Config.ARGB_8888);

                int bumpSize = altoPieza / 4;
                Canvas canvas = new Canvas(piezaPuzzle);
                Path path = new Path();
                path.moveTo(offsetX, offsetY);
                if (fila == 0) {
                    //Pieza de arriba
                    path.lineTo(piezaBitmap.getWidth(), offsetY);
                } else {
                    path.lineTo(offsetX + (piezaBitmap.getWidth() - offsetX) / 3, offsetY);
                    path.cubicTo(offsetX + (piezaBitmap.getWidth() - offsetX) / 6, offsetY - bumpSize, offsetX + (piezaBitmap.getWidth() - offsetX) / 6 * 5, offsetY - bumpSize, offsetX + (piezaBitmap.getWidth() - offsetX) / 3 * 2, offsetY);
                    path.lineTo(piezaBitmap.getWidth(), offsetY);
                }

                if (columna == columnas - 1){
                    //Pieca derecha
                    path.lineTo(piezaBitmap.getWidth(), piezaBitmap.getHeight());
                } else {
                    path.lineTo(piezaBitmap.getWidth(), offsetY + (piezaBitmap.getHeight() - offsetY) / 3);
                    path.cubicTo(piezaBitmap.getWidth() - bumpSize, offsetY + (piezaBitmap.getHeight() - offsetY) / 6, piezaBitmap.getWidth() - bumpSize, offsetY + (piezaBitmap.getHeight() - offsetY) / 6 * 5, piezaBitmap.getWidth(), offsetY + (piezaBitmap.getHeight() - offsetY) / 3 * 2);
                    path.lineTo(piezaBitmap.getWidth(), piezaBitmap.getHeight());
                }
                if (fila == filas - 1) {
                    // boton pieza
                    path.lineTo(offsetX, piezaBitmap.getHeight());
                } else {
                    path.lineTo(offsetX + (piezaBitmap.getWidth() - offsetX) / 3 * 2, piezaBitmap.getHeight());
                    path.cubicTo(offsetX + (piezaBitmap.getWidth() - offsetX) / 6 * 5, piezaBitmap.getHeight() - bumpSize, offsetX + (piezaBitmap.getWidth() - offsetX) / 6, piezaBitmap.getHeight() - bumpSize, offsetX + (piezaBitmap.getWidth() - offsetX) / 3, piezaBitmap.getHeight());
                    path.lineTo(offsetX, piezaBitmap.getHeight());
                }

                if (columna == 0) {
                    // pieza derecha
                    path.close();
                } else {
                    path.lineTo(offsetX, offsetY + (piezaBitmap.getHeight() - offsetY) / 3 * 2);
                    path.cubicTo(offsetX - bumpSize, offsetY + (piezaBitmap.getHeight() - offsetY) / 6 * 5, offsetX - bumpSize, offsetY + (piezaBitmap.getHeight() - offsetY) / 6, offsetX, offsetY + (piezaBitmap.getHeight() - offsetY) / 3);
                    path.close();
                }
                Paint paint = new Paint();
                paint.setColor(0XFF000000);
                paint.setStyle(Paint.Style.FILL);

                canvas.drawPath(path, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(piezaBitmap, 0, 0, paint);

                // Se crea un borde blanco
                Paint border = new Paint();
                border.setColor(0X80FFFFFF);
                border.setStyle(Paint.Style.STROKE);
                border.setStrokeWidth(8.0f);
                canvas.drawPath(path, border);

                // Se crea un borde negro
                border = new Paint();
                border.setColor(0X80000000);
                border.setStyle(Paint.Style.STROKE);
                border.setStrokeWidth(3.0f);
                canvas.drawPath(path, border);

                // set the resulting bitmap to the piece
                pieza.setImageBitmap(piezaPuzzle);

                piezas.add(pieza);
                xCoord += anchoPieza;
            }
            yCoord += altoPieza;
        }
        return piezas;

    }
    private int[] getBitmapPositionInsideImageView(ImageView imageView) {
        int[] ret = new int[4];

        if (imageView == null || imageView.getDrawable() == null)
            return ret;

        // recibe las dimensiones de la imagen
        // recibe los valores de la matriz de la imagen y las añade en un array
        float[] f = new float[9];
        imageView.getImageMatrix().getValues(f);

        // Saca los valores usando constantes (si el aspect ratio se mantuvo, scaleX == scaleY)
        final float scaleX = f[Matrix.MSCALE_X];
        final float scaleY = f[Matrix.MSCALE_Y];

        final Drawable d = imageView.getDrawable();
        final int origW = d.getIntrinsicWidth();
        final int origH = d.getIntrinsicHeight();

        // Calcula las dimensiones
        final int actW = Math.round(origW * scaleX);
        final int actH = Math.round(origH * scaleY);

        ret[2] = actW;
        ret[3] = actH;

        // Agarra la posicion de la imagen
        int imgViewW = imageView.getWidth();
        int imgViewH = imageView.getHeight();

        int top = (imgViewH - actH) / 2;
        int left = (imgViewW - actW) / 2;

        ret[0] = left;
        ret[1] = top;

        return ret;
    }
    public void startChronometer() {
        ((Chronometer) findViewById(R.id.chronometer1)).start();
    }
    public void checkGameOver() {
        if (isGameOver()) {
            time = getChronometer();
            if (counter == 1){
                finalJuego();
            }else
                continuar();
        }
    }
    public long getChronometer() {
        long time = ((Chronometer) findViewById(R.id.chronometer1)).getBase();
        return time;
    }
    public void secondChrono(){
        ((Chronometer) findViewById(R.id.chronometer1)).setBase(time);
        ((Chronometer) findViewById(R.id.chronometer1)).start();
    }
    private void finalJuego(){

        Tiempo = ((Chronometer) findViewById(R.id.chronometer1)).getText().toString(); //Guardamos el tiempo en String
        Log.d("myTag",Tiempo); //Sacamos tiempo por logCat

        Intent intent = new Intent(ActividadPuzzle.this, Felicidades.class);
        intent.putExtra("tiempo", Tiempo);
        startActivity(intent);
    }
    private boolean isGameOver() {
        for (PiezaPuzzle pieza : piezas) {
            if (pieza.canMove) {
                return false;
            }
        }
        return true;
    }
}
