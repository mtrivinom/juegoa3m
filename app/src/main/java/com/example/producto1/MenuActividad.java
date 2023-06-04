package com.example.producto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MenuActividad extends AppCompatActivity {
    Button btn_vArcade, btn_ayuda, btn_ranking, btn_login,btn_logout;
    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_vArcade = (Button) findViewById(R.id.btn_arcade);
        btn_ayuda = (Button) findViewById(R.id.btn_ayuda);
        btn_ranking = (Button) findViewById(R.id.btn_ranking);
        btn_logout = findViewById(R.id.logout);

        auth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplication(), Login.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(user.getEmail());
        }

        btn_logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplication(), Login.class);
                startActivity(intent);
                finish();
            }
        });

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
