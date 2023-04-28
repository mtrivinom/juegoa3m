package com.softdroid.puzzlev2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CongratsActivity extends PuzzleActivity{

    EditText editText;
    Button submitButton;
    Button menu;
    String nombre, userEmail;
    ArrayList<Puntuacion> lista;
    ArrayList<String> listaRanking, listaRankingFirebase;
    int option;
    //Instancia de FirebaseStorage
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        editText = (EditText) findViewById(R.id.editText);

        submitButton = (Button) findViewById(R.id.button);
        Bundle datos = this.getIntent().getExtras();
        option = datos.getInt("opcion_audio");
        listaRankingFirebase = new ArrayList<String>();

        Intent intent = getIntent();
        userEmail = intent.getStringExtra("email");
        editText.setText(userEmail);

        //Este intent manda la opcion 3 al servicio para que pare la musica y asi no entre en loop
        //al regresar al menu (si da problemas aquí se puede poner en el PuzzleActivity, en el método isgameover)
        /*
        Intent intent = new Intent (CongratsActivity.this, MediaPlayerService.class);
        int option = 3;
        intent.putExtra ( "option", option);
        startService(intent);

         */

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // get the data with the
                        // "editText.text.toString()"
                        nombre = editText.getText().toString();

                        // check whether the retrieved data is
                        // empty or not based on the emptiness
                        // provide the Toast Message
                        if (nombre.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Please Enter your AKA", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Record saved!", Toast.LENGTH_SHORT).show();
                            //addEventToCalendar();
                            addCalendarFirebase();
                        }
                    }
                });

        menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CongratsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }
    public void insertDB(){
        String time = getIntent().getStringExtra("tiempo");
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(CongratsActivity.this);//Crea conexión y BD
        adminSQLiteOpenHelper.insertar(nombre, time);//Insertamos datos en BD
        Intent intent = new Intent(CongratsActivity.this, MenuActivity.class);
        intent.putExtra("email", userEmail);
        startActivity(intent);

    }

    public void addEventToCalendar(){
        String time = getIntent().getStringExtra("tiempo");
        AdminSQLiteOpenHelper adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(CongratsActivity.this);
        lista = adminSQLiteOpenHelper.getPuntuacion();

        listaRanking = new ArrayList<String>();

        for (int i=0; i<lista.size(); i++){
            listaRanking.add(lista.get(i).getTime());
        }


        if(listaRanking.size() >= 1){
            if(time.compareTo(listaRanking.get(0)) < 0){
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "New Record" );
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, nombre + " time: " + time);
                insertDB();
                startActivity(calIntent);
            }else{
                insertDB();
              }
        }else{
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "New Record" );
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, nombre + " time: " + time);
                insertDB();
                startActivity(calIntent);
            }

        }

    public void addDataFirebase() {
        String time = getIntent().getStringExtra("tiempo");
        Map<String, Object> user = new HashMap<>();
        user.put("user", userEmail);
        user.put("puntuacion", time);
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent intent = new Intent(CongratsActivity.this, MenuActivity.class);
                        intent.putExtra("email", userEmail);
                        startActivity(intent);
                    }
                });



    }

    public void addCalendarFirebase(){

        db.collection("users")
                .orderBy("puntuacion")
                .limit(10)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String timepoFirebase = document.getString("puntuacion");
                                listaRankingFirebase.add(timepoFirebase);
                            }
                        } else {
                            Log.w("datos firebase error", "Error getting documents.", task.getException());

                        }
                        comprobarRecord();
                    }

                });


        }

    public void comprobarRecord(){
        String time = getIntent().getStringExtra("tiempo");
        if(listaRankingFirebase.size() >= 1){
            Log.d("ListaRankingFirebase", listaRankingFirebase.get(0));
            if(time.compareTo(listaRankingFirebase.get(0)) < 0) {
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "New Record");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, userEmail + " time: " + time);
                addDataFirebase();
                startActivity(calIntent);
            }else{
                addDataFirebase();
            }
        }else{
            Intent calIntent = new Intent(Intent.ACTION_INSERT);
            calIntent.setType("vnd.android.cursor.item/event");
            calIntent.putExtra(CalendarContract.Events.TITLE, "New Record");
            calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "");
            calIntent.putExtra(CalendarContract.Events.DESCRIPTION, userEmail + " time: " + time);
            addDataFirebase();
            startActivity(calIntent);
        }
    }
   @Override
    protected void onPause() {
        super.onPause();
        playPause(4);
    }

    @Override
    protected void onResume() {
        super.onResume();
        playPause(option);
    }

    public void playPause(int opcion){

        Intent intent = new Intent (CongratsActivity.this, MediaPlayerService.class);
        int option = opcion;
        intent.putExtra ( "option", option);
        startService(intent);
    }

    }

