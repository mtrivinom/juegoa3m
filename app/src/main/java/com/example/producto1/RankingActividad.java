package com.example.producto1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class RankingActividad extends AppCompatActivity {
    ListView listView; //Listview para introducir y mostrar la lista
    ArrayList<Puntuacion> lista;// ArrayList donde guardamos los registros de la bd
    ArrayList<String> listaRanking;
    ArrayList<String> listaFirebaseUsers;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ArrayAdapter adapter; //adaptador para mostrar los datos

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        listView = (ListView) findViewById(R.id.lista); //vinculamos la variable listview con la listview del layout
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(RankingActividad.this);//Crea conexión y BD
        listaFirebaseUsers = new ArrayList<String>();

        lista = adminSQLiteOpenHelper.getPuntuacion(); //asignamos en el arraylist lista el resultado de la llamada al método getPuntuacion
        //Log.d("milista", lista);
        obtenerLista();
        obtenerDatosfirebase();


    }

    private void obtenerLista(){
        listaRanking = new ArrayList<String>();
        for (int i=0; i<lista.size(); i++){
            listaRanking.add(String.valueOf(i+1) + "  " + lista.get(i).getName() + "  time: " + lista.get(i).getTime());
            ;        }

    }
    public void obtenerDatosfirebase(){
        db.collection("users")
                .orderBy("puntuacion")
                .limit(10)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("datos firebase", document.getId() + " => " + document.getData());
                                String tempString = document.getString("user") + " time: " + document.getString("puntuacion");
                                //Log.d("tempString", tempString);
                                listaFirebaseUsers.add(tempString);

                            }
                        } else {
                            Log.w("datos firebase error", "Error getting documents.", task.getException());
                        }
                        rellenarAdapter();
                    }
                });
    }

    public void rellenarAdapter(){
        Log.d("Elemento de la lista", listaFirebaseUsers.get(0));
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaFirebaseUsers);
        listView.setAdapter(adapter);
    }
}
