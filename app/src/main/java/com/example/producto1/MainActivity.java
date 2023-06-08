package com.example.producto1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager assetmanager = getAssets();
        try{
            final String[] files = assetmanager.list("img");
            GridView grid = findViewById(R.id.grid);
            grid.setAdapter(new AdaptarImagen(this));
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getApplicationContext(), ActividadPuzzle.class);
                    intent.putExtra("assetName", files[i % files.length]);
                    startActivity(intent);
                }
            });
        } catch (IOException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT);
        }
    }
  */

public class MainActivity extends AppCompatActivity {

    private FirebaseStorage storage;
    private StorageReference storageRef;

    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar BBDD Firebase
        FirebaseApp.initializeApp(this);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        // Obtén una lista de las referencias a las imágenes en Firebase Storage
        StorageReference imagesRef = storageRef.child("gs://android-a3m.appspot.com");

        imagesRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                // Obtener la lista de referencias a las imágenes
                List<StorageReference> imageRefs = listResult.getItems();

                if (imageRefs != null) {
                    GridView grid = findViewById(R.id.grid);
                    grid.setAdapter(new AdaptarImagen(MainActivity.this, imageRefs));
                    grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            // Obtener la referencia a la imagen seleccionada
                            StorageReference imageRef = imageRefs.get(i % imageRefs.size());

                            // Obtener el nombre del archivo de la imagen seleccionada
                            String imageName = imageRef.getName();

                            // Pasar la información a la actividad ActividadPuzzle
                            Intent intent = new Intent(getApplicationContext(), ActividadPuzzle.class);
                            intent.putExtra("Foto", imageName);
                            startActivity(intent);
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "No se encontraron imágenes", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error al obtener la lista de imágenes", Toast.LENGTH_SHORT).show();
            }
        });
    }



    //PRUBEA 2
    //Descargar las imagenes de la Firebase Storage:
    /* while (i <= 3) {
        ConversorI = String.valueOf(i);
        StorageReference StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://android-a3m.appspot.com/" + conversorI + ".jpg");
        try {
            File localfile = File.createTempFile("Foto" + conversorI, ".jpg");
            StorageReference.getFile(localfile)
                    .addOnSuccessListener(new onSuccessListener<FileDownloadTask.TaskSnapshot>(){
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot){

                        }
                    });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/



    /* NO USAMOS YA SQL
    public void AdminSQLiteOpenHelper() {
        AdminSQLiteOpenHelper dbHelper = new AdminSQLiteOpenHelper(this);      //Conexion al BBDDD
        SQLiteDatabase db = dbHelper.getWritableDatabase(); // Permiso para escribir en la BBDD

        if (db != null) {
            // Insert con execSQL
            db.execSQL("INSERT INTO ranking (name, time) VALUES (string, double)");

            // Update con execSQL
            db.execSQL("UPDATE ranking SET ranking= null WHERE name= null");
            db.execSQL("UPDATE ranking SET ranking= null WHERE time= null");

            // Eliminamos datos
            db.execSQL("DELETE FROM ranking WHERE name=null");
            db.execSQL("DELETE FROM ranking WHERE time=null");

            // Consultamos datos en la tabla
            Cursor c = db.rawQuery("SELECT _id, name, time FROM ranking ORDER BY time ASC", null);

            //Cerramos el cursor y la conexion con la base de datos
            ((Cursor) c).close();
            db.close();

        }

    }*/
}