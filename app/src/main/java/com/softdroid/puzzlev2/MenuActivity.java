package com.softdroid.puzzlev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.sql.SQLInput;
import java.util.ArrayList;

//Operadores de autentificacion
enum ProviderType{
    BASIC,
    GOOGLE
}

public class MenuActivity extends AppCompatActivity {

    Button btn_vArcade, btn_ayuda, btn_ranking, btn_playpause, btn_playplay, btn_seleccionar;
    boolean playing = true;
    int option;
    boolean primeraVez = true;
    Uri soundUri;
    private final int PICKER = 1;
    MediaPlayer mediaPlayer;
    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_vArcade = (Button) findViewById(R.id.btn_arcade);
        btn_ayuda = (Button) findViewById(R.id.btn_ayuda);
        btn_ranking = (Button) findViewById(R.id.btn_ranking);
        btn_playpause = (Button) findViewById(R.id.btn_musicOn);
        btn_playplay = (Button) findViewById(R.id.btn_musicOn2);
        btn_seleccionar = (Button) findViewById(R.id.btn_seleccionar);

        Intent intent = getIntent();
        userEmail = intent.getStringExtra("email");

        /*
        Este intent con la variable option con valor 1 se envia al servicio e inicia el reproductor
        */
        option = 1;
        //playPause(option);

        btn_vArcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, testFotoActivity.class);
                intent.putExtra("opcion_audio", option);
                intent.putExtra("email", userEmail);
                startActivity(intent);
            }
        });

        btn_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
            Intent intent = new Intent(MenuActivity.this, AyudaActivity.class);
            startActivity(intent);
        }
        });

        btn_ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        });

        /*
        si el usuaro clica en el boton de pausa se comprueba el estado del booleano, si esta sonando
        la musica se pone el icono de play y si esta pausada y se clica se pone el de pausa
        Después se manda un intent con el valor option distinto a 1 para que se ejecute la orden de
        pausar o reanudar el mediaplayer
         */
        btn_playplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    option = 5;
                    playPause(option);
                }
        });

        btn_playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option = 4;
                playPause(option);
            }
        });

        btn_seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PickFile();
            }
        });


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
        Intent intent = new Intent (MenuActivity.this, MediaPlayerService.class);
        int option = opcion;
        if(option == 6){
            String patchString = soundUri.toString();
            intent.putExtra ( "cancacion", patchString);

        }
        intent.putExtra ( "option", option);
        startService(intent);
    }

    protected void PickFile(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try{
            startActivityForResult(
                    Intent.createChooser(
                            intent, "Intale un gestor de archivos"),
                            PICKER);
        }catch (android.content.ActivityNotFoundException ex){

        }
     }


    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case PICKER:
                if (resultCode == RESULT_OK)
                {
                    soundUri = data.getData();
                    option = 6;
                    playPause(option);
                    /*
                    mediaPlayer = MediaPlayer.create ( this, soundUri );
                    mediaPlayer.setLooping ( true );
                    mediaPlayer.start();
                    */

                    break;
                }
        }
    }

    public String getRealPathFromUri(Uri soundUri){
        Cursor cursor = null;
        try{
            String[] proj = {MediaStore.Audio.Media.DATA};
            cursor = getApplicationContext().getContentResolver().query(soundUri,proj,null,null,null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }finally{
            if(cursor != null){
                cursor.close();
            }

        }

    }

}
