package com.example.producto1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActividad extends AppCompatActivity {
    Button btn_vArcade, btn_ayuda, btn_ranking, btn_playpause, btn_playplay, btn_seleccionar;
    int opcion;
    Uri soundUri;
    private final int PICKER = 1;



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

        opcion = 1;

        btn_vArcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActividad.this, MainActivity.class);
                intent.putExtra("opcion_audio", opcion);
                startActivity(intent);
            }
        });

        btn_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(MenuActividad.this, AyudaActividad.class);
                startActivity(intent);
            }
        });

        btn_ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActividad.this, RankingActividad.class);
                startActivity(intent);
            }
        });
        btn_playplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcion = 5;
                playPause(opcion);
            }
        });
        btn_playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcion = 4;
                playPause(opcion);
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
        playPause(opcion);
    }
    public void playPause(int opcion){
        Intent intent = new Intent (MenuActividad.this, MediaPlayerService.class);
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
                            intent, "Instale un gestor de archivos"),
                    PICKER);
        }catch (android.content.ActivityNotFoundException ex){

        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case PICKER:
                if (resultCode == RESULT_OK)
                {
                    soundUri = data.getData();
                    opcion = 6;
                    playPause(opcion);
                    break;
                }
        }
    }

}

