package com.example.producto1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

//Librerias para Firebase
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import androidx.annotation.NonNull;
import com.google.firebase.storage.ListResult;
import com.google.android.gms.tasks.OnSuccessListener;




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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar BBDD Firebase
        FirebaseApp.initializeApp(this);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        // Obtén una lista de las referencias a las imágenes en Firebase Storage
        StorageReference imagesRef = storageRef.child("gs://android-a3m.appspot.com/");

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

                    // Procesar cada imagen dentro del bucle
                    for (int i = 1; i <= imageRefs.size(); i++) {
                        String imageName = "Foto" + i + ".jpg";
                        StorageReference imageRef = storageRef.child(imageName);
                        // Resto del código para procesar la imagen

                        // Ejemplo de uso: cargar la imagen con Glide
                        ImageView imageView = findViewById(R.id.imageView);
                        Glide.with(MainActivity.this)
                                .load(imageRef)
                                .into(imageView);
                    }
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

    }
}