package com.example.producto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActividad extends AppCompatActivity {
    Button btn_vArcade, btn_ayuda, btn_ranking, btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_vArcade = (Button) findViewById(R.id.btn_arcade);
        btn_ayuda = (Button) findViewById(R.id.btn_ayuda);
        btn_ranking = (Button) findViewById(R.id.btn_ranking);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_vArcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActividad.this, MainActivity.class);
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
    }
}
