package com.project.MobileProgramming.khansamazaya;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class login_page extends AppCompatActivity {

    EditText email, password;
    TextView register;
    FirebaseFirestore db;
    ProgressBar progressBar;
    private Button login;
    private FirebaseAuth auth;
    private AuthenticationManager authManager;
    SessionManager sessionManager;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        progressBar = findViewById(R.id.progresBar);
        progressBar.setVisibility(View.INVISIBLE);
        register = findViewById(R.id.register);
        auth = FirebaseAuth.getInstance();
        authManager = new AuthenticationManager();
        sessionManager = new SessionManager(getApplicationContext());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), reguister.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().length()>0 && password.getText().length()>0){
                    String enteredEmail = email.getText().toString();
                    String enteredPassword = password.getText().toString();
                    login(enteredEmail, enteredPassword);
                    progressBar.setVisibility(View.VISIBLE);


                }else{
                    Toast.makeText(getApplicationContext(), "data belum terisi semua",
                            Toast.LENGTH_LONG).show();
                }

            }

            private void login(String email, String password) {
                progressBar.setVisibility(View.VISIBLE);
                authManager.signInWithEmailAndPassword(email, password,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            sessionManager.setLogInStatus(true);
                            reload();
                        }else {
                            Toast.makeText(getApplicationContext(), "Email atau Password salah", Toast.LENGTH_LONG).show();
                        }

                    }

                    private void reload() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        },1000);
                    }
                });
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }
}