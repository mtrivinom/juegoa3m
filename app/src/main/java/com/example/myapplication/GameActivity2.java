package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

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
        loadDataToViews();
    }

    private void loadDataToViews(){
        emptyX=3;
        emptyY=3;
        for (int i = 0; i < group.getChildCount() - 1; i++){
            buttons[i/4][i%4].setText(String.valueOf(tiles[i]));
            buttons[1/4][i%4].setBackgroundResource(android.R.drawable.btn_default);
        }

        buttons[emptyX][emptyY].setText("");
        buttons[emptyX][emptyY].setBackgroundColor(ContextCompat.getColor(this,R.color.colorFreeButton));
    }

    private void generateNumbers(){
        int n=15;
        Random random= new Random();
        while (n>1){
            int randomNum = random.nextInt(n--);
            int temp = tiles[randomNum];
            tiles[randomNum]=tiles[n];
            tiles[n] = temp;
        }

        if (!isSolvable()){
            generateNumbers();
        }
    }

    private boolean isSolvable(){
        int countInvenrsions=0;
        for (int i = 0; i < 15; i++) {
            for(int j = 0; j < i; j++){
                if (tiles[j]>tiles[i])
                    countInvenrsions++;
            }
        }
        return countInvenrsions%2 == 0;
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

    public void buttonClick(View view){
        Button button = (Button) view;
        int x = button.getTag().toString().charAt(0)-'0';
        int y = button.getTag().toString().charAt(1)-'0';

        if((Math.abs(emptyX-x)==1&&emptyY==y)||(Math.abs(emptyY-y)==1&&emptyX==x)){
            buttons[emptyX][emptyY].setText(button.getText());
            buttons[emptyX][emptyY].setBackgroundResource(android.R.drawable.btn_default);
            button.setText("");
            button.setBackgroundColor(ContextCompat.getColor(this,R.color.colorFreeButton));
            emptyX=x;
            emptyY=y;
            checkWin();
        }
    }

    private void checkWin(){
        boolean isWin = false;
        if (emptyX==3&&emptyY==3){
            for (int i = 0; i < group.getChildCount() - 1; i++){
                if (buttons[i/4][i%4].getText().toString().equals(String.valueOf(i+1))){
                    isWin=true;
                }else{
                    isWin=false;
                    break;
                }
            }
        }

        if (isWin){
            Toast.makeText(this, "Awebo Ganaste", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < group.getChildCount(); i++) {
                buttons[i/4][i%4].setClickable(false);
            }
        }
    }
}

