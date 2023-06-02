package com.example.producto1;

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

public class LoginActivity extends AppCompatActivity{

    private static final int GOOGLE_SIGN_IN = 100;
    Button btn_reg, btn_log, btn_google;
    EditText editName, editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        Log.d("tag", String.valueOf ("yes"));
        btn_reg = (Button) findViewById(R.id.btn_reg);
        btn_log = (Button) findViewById(R.id.btn_log);
        btn_google = (Button) findViewById(R.id.btn_google);
        setup();
    }

    private void setup(){
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName  = (EditText) findViewById(R.id.editText);
                editPassword = (EditText) findViewById(R.id.editText);
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                Log.d("datos", String.valueOf ( name + " " + password ));
                if(name != null && password !=null){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(name,password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
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

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName  = (EditText) findViewById(R.id.editText);
                editPassword = (EditText) findViewById(R.id.editText);
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                Log.d("datos", String.valueOf ( name + " " + password ));
                if(name != null && password !=null){
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(name,password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
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

        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleSignInOptions googleConf = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id2))
                        .requestEmail()
                        .build();
                GoogleSignInClient googleClient = GoogleSignIn.getClient(LoginActivity.this, googleConf);
                googleClient.signOut();
                startActivityForResult(googleClient.getSignInIntent(), GOOGLE_SIGN_IN);
            }
        });

    }

    private void startHome(String email, ProviderType provider){
        Intent intent = new Intent(LoginActivity.this, MenuActividad.class);
        intent.putExtra("email", email);
        intent.putExtra("provider", provider.name());
        startActivity(intent);
    }

    private void showAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Error");
        alert.setMessage("Error de Autenticación de Usuario");
        alert.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
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
