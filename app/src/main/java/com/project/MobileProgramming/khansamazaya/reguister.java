package com.project.MobileProgramming.khansamazaya;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.Objects;

public class reguister extends AppCompatActivity {

    EditText name, email, password, confirm_password;
    Button register;
    TextView login;
    String username, surel, pass, confpass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reguister);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.edtemail);
        password = findViewById(R.id.edtpassword);
        confirm_password = findViewById(R.id.conf_edtpassword);
        register = findViewById(R.id.regist);
        login = findViewById(R.id.log_in);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), login_page.class));
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surel = email.getText().toString();
                pass = password.getText().toString();
                confpass = confirm_password.getText().toString();

                if (!surel.isEmpty()&&!pass.isEmpty()&&!confpass.isEmpty()) {
                    if (pass.equals(confpass)){
                        auth.createUserWithEmailAndPassword(String.valueOf(surel), String.valueOf(pass)).addOnCompleteListener(task1 -> {
                            if (task1.isSuccessful()) {
                                Log.d("FirebaseAuth", "Pendaftaran berhasil.");
                                Toast.makeText(getApplicationContext(), "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), login_page.class));
                                finish();
                            } else {
                                Log.e("FirebaseAuth", "Error saat mendaftar: " + task1.getException());
                                Toast.makeText(getApplicationContext(), "Pendaftaran gagal", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        Toast.makeText(getApplicationContext(), "password dan konfirmasi password tidak sama", Toast.LENGTH_SHORT).show();
                        Log.d("FirebaseAuth", "password dan konfirmasi password tidak sama");
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Mohon isi semua kolom", Toast.LENGTH_SHORT).show();
                    Log.d("FirebaseAuth", "Mohon isi semua kolom");
                }
            }
        });
    }
}