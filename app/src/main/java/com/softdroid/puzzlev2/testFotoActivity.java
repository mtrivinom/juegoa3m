package com.softdroid.puzzlev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class testFotoActivity extends AppCompatActivity {
    public static final Set<String> TMP_FILES = new HashSet<>();//Borrado de archivos tempoprales en cache
    StorageReference storageReference;
    String conversorI;
    int option;
    int i = 1;
    String localFilePath, userEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_foto);
        deleteArchivosPath();
        //deleteTempFiles();
        Bundle datos = this.getIntent().getExtras();
        option = datos.getInt("opcion_audio");

        Intent intent = getIntent();
        userEmail = intent.getStringExtra("email");

        //Descargamos todas las fotos de firebase storage - 1
         while (i <= 6) {
            conversorI = String.valueOf(i);
            storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://softdroid-10c6c.appspot.com/images/" + conversorI + ".jpg");
            try {
                File localfile = File.createTempFile("image_" + conversorI, ".jpg");
                storageReference.getFile(localfile)
                        .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {


                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

         //Descargamos la foto 0 de firebase, cuando está completa, arrancamos activity
        storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://softdroid-10c6c.appspot.com/images/0.jpg");
        try {
            File localfile = File.createTempFile("image_0", ".jpg");
            storageReference.getFile(localfile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            localFilePath = localfile.getPath();
                            startHome(localFilePath);
                            //mostrarArchivosPath();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startHome(String localFilePath){
        Intent intent = new Intent(testFotoActivity.this, PuzzleActivity.class);
        intent.putExtra("FilePath", localFilePath);
        intent.putExtra("opcion_audio", option);
        intent.putExtra("email", userEmail);
        startActivity(intent);
    }

    public void deleteArchivosPath(){

        File f = new File("/data/data/com.softdroid.puzzlev2/cache");
        //Creo el array de tipo File con el contenido de la carpeta
        File[] files = f.listFiles();

        //Hacemos un Loop por cada fichero para extraer el nombre de cada uno
        for (int i = 0; i < files.length; i++) {
            files[i].delete();

        }

    }
    //Eliminar archivos temporales en cache
    public void deleteTempFiles() {
        for(String myTempFile: TMP_FILES) {
            try {
                new File(myTempFile).delete();
            } catch (Exception e) {
                // Handle if needed.
            }
        }
    }
}