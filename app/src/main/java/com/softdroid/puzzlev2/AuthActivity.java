package com.softdroid.puzzlev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Locale;

public class AuthActivity extends AppCompatActivity {
    private static final int GOOGLE_SIGN_IN = 100;
    Button signUpButton, accesButton, googleButton;
    EditText editName, editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        Log.d("tag", String.valueOf ("yes"));
        // Setup
        signUpButton = (Button) findViewById(R.id.singinbutton);
        accesButton = (Button) findViewById(R.id.loginbutton);
        googleButton = (Button) findViewById(R.id.googlebutton);
        setup();

    }

    private void setup(){
      //setTitle("Autenticación");

        //Crear usuario con email y password
      signUpButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              editName  = (EditText) findViewById(R.id.editTextTextEmailAddress);
              editPassword = (EditText) findViewById(R.id.editTextTextPassword);
              String name = editName.getText().toString();
              String password = editPassword.getText().toString();
              Log.d("datos", String.valueOf ( name + " " + password ));
                if(name != null && password !=null){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(name,password)
                            .addOnCompleteListener(AuthActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Log.d("tag", String.valueOf ( name + " " + password ));
                                        startHome(task.getResult().getUser().getEmail(),ProviderType.BASIC);

                                    }else{
                                        Log.d("error", String.valueOf ("Error"));
                                        showAlert();
                                    }

                                }
                            });
                }
          }

      });

        //Acceder a la aplicación con credenciales registradas en firebase email and password
      accesButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              editName  = (EditText) findViewById(R.id.editTextTextEmailAddress);
              editPassword = (EditText) findViewById(R.id.editTextTextPassword);
              String name = editName.getText().toString();
              String password = editPassword.getText().toString();
              Log.d("datos", String.valueOf ( name + " " + password ));
              if(name != null && password !=null){
                  FirebaseAuth.getInstance().signInWithEmailAndPassword(name,password)
                          .addOnCompleteListener(AuthActivity.this, new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  if(task.isSuccessful()){
                                      Log.d("tag", String.valueOf ( name + " " + password ));
                                      startHome(task.getResult().getUser().getEmail(),ProviderType.BASIC);

                                  }else{
                                      Log.d("error", String.valueOf ("Error"));
                                      showAlert();
                                  }

                              }
                          });
              }
          }

      });

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleSignInOptions googleConf = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id2))
                        .requestEmail()
                        .build();

                GoogleSignInClient googleClient = GoogleSignIn.getClient(AuthActivity.this, googleConf);
                googleClient.signOut();
                startActivityForResult(googleClient.getSignInIntent(), GOOGLE_SIGN_IN);

                }
            });


    }

    //Llamada al menu activity junto a los parámetros email y provider
    private void startHome(String email, ProviderType provider){
        Intent intent = new Intent(AuthActivity.this, MenuActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("provider", provider.name());
        startActivity(intent);

    }

    //Mensaje de alerta en caso de fallo de autentificación
    private void showAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Error");
        alert.setMessage("Se ha producido un error autenticando al usuario: Usuario existente u otros..");
        alert.setPositiveButton("confirmar", new DialogInterface.OnClickListener() {
          @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.create().show();
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GOOGLE_SIGN_IN){
            Log.d("GoogleAccount", String.valueOf ("onActivityResult"));
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                if(account != null){
                    AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
                    FirebaseAuth.getInstance().signInWithCredential(credential);
                    if(task.isSuccessful()){
                        startHome(account.getEmail(),ProviderType.GOOGLE);

                    }else{
                        showAlert();
                    }

                }

            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

    }

}