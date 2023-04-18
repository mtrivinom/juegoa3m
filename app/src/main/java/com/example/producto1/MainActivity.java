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
import android.widget.Toast;

import java.io.IOException;

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