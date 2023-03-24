package com.example.myapplication;

import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class GameActivity2 extends AppCompatActivity {

    private int emptyX=3;
    private int emptyY=3;
    private RelativeLayout group;
    private Button[][] buttons;
    private int[] tiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        loadViews();
        loadNumbers();
        generateNumbers();
    }

    private void generateNumbers(){
        int n=15;
        Random random= new Random();
        while (n>1){
            int randomNum = random.nextInt(n--);
            int temp = tiles[randomNum];
            tiles[randomNum]=tiles[n];
        }
    }

    private void loadNumbers(){
        tiles = new int[16];
        for (int i = 0; i < group.getChildCount() - 1; i++){
            tiles[i] = i + 1;
        }
    }

    private void loadViews(){
        group=findViewById(R.id.group);
        buttons = new Button[4][4];

        for (int i = 0; i < group.getChildCount() ; i++){
            buttons[i/4][i%4] = (Button) group.getChildAt(i);
        }
    }
}