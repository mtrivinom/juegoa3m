package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button buttonStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartGame = findViewById(R.id.button_start_game);
        buttonStartGame.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                //startActivity(new Intent(MainActivity.this,GameActivity2.class));

            }
        });
    }
}