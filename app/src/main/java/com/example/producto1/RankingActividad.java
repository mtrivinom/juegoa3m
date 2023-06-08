package com.example.producto1;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RankingActividad extends AppCompatActivity {
    ListView listView;
    ArrayList<Puntuacion> lista;
    ArrayList<String> listaRanking;
    ArrayAdapter adapter;
    DatabaseReference database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        listView = findViewById(R.id.lista);
        lista = new ArrayList<>();
        listaRanking = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaRanking);
        listView.setAdapter(adapter);

        // Obtén una instancia de la base de datos de Firebase
        database = FirebaseDatabase.getInstance().getReference();

        // Obtén las puntuaciones desde Firebase
        obtenerPuntuaciones();

        // Obtén el nombre del EditText
        EditText editTextNombre = findViewById(R.id.editText);
        String nombre = editTextNombre.getText().toString();

        // Obtén el tiempo
        double tiempo = 45.5;


        // Llama a la función guardarPuntuacionFirebase y pasa el nombre
        guardarPuntuacionFirebase(nombre, tiempo); //FALLA AQUI VARIABLE TIEMPO
    }


    private void obtenerPuntuaciones() {
        database.child("ranking").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista.clear();
                listaRanking.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Puntuacion puntuacion = snapshot.getValue(Puntuacion.class);
                    lista.add(puntuacion);
                    listaRanking.add(String.format("%d  %s  time: %.2f", listaRanking.size() + 1, puntuacion.getName(), puntuacion.getTime()));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Manejar el error si es necesario
            }
        });
    }

    /*
    private void guardarPuntuacionFirebase() {
        DatabaseReference puntuacionRef = database.child("ranking").push();
        int puntuacionId = Integer.parseInt(puntuacionRef.getKey());

        // Obtén el nombre y tiempo del jugador desde tu lógica de juego o elementos de interfaz
        String nombreJugador = obtenerNombreJugador(); //
        String tiempoJugador = obtenerTiempoJugador(); //

        Puntuacion puntuacion = new Puntuacion(puntuacionId, nombreJugador, tiempoJugador);
        puntuacionRef.setValue(puntuacion);
    }
    */


    private void guardarPuntuacionFirebase(String nombre, String tiempo) {
        // Obtén una instancia de la base de datos
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        // Crea un nuevo nodo para la puntuación
        DatabaseReference puntuacionRef = database.child("puntuaciones").push();

        // Crea un objeto Puntuacion con los datos proporcionados
        Puntuacion puntuacion = new Puntuacion(nombre, tiempo);

        // Guarda la puntuación en la base de datos
        puntuacionRef.setValue(puntuacion);
    }

    private void obtenerLista(){
        listaRanking = new ArrayList<String>();
        for (int i=0; i<lista.size(); i++){
            listaRanking.add(String.valueOf(i+1) + "  " + lista.get(i).getName() + "  time: " + lista.get(i).getTime());
            ;        }

    }

}


/*
public class RankingActividad extends AppCompatActivity {
    ListView listView; //Listview para introducir y mostrar la lista
    ArrayList<Puntuacion> lista;// ArrayList donde guardamos los registros de la bd
    ArrayList<String> listaRanking;

    ArrayAdapter adapter; //adaptador para mostrar los datos

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        listView = (ListView) findViewById(R.id.lista); //vinculamos la variable listview con la listview del layout
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(RankingActividad.this);//Crea conexión y BD

        lista = adminSQLiteOpenHelper.getPuntuacion(); //asignamos en el arraylist lista el resultado de la llamada al método getPuntuacion
        //Log.d("milista", lista);
        obtenerLista();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaRanking); //creamos un adaptador
        listView.setAdapter(adapter); //enviamos la listview con el adaptader para mostrar su contenido


    }

    private void obtenerLista(){
        listaRanking = new ArrayList<String>();
        for (int i=0; i<lista.size(); i++){
            listaRanking.add(String.valueOf(i+1) + "  " + lista.get(i).getName() + "  time: " + lista.get(i).getTime());
            ;        }

    }
}

 */
