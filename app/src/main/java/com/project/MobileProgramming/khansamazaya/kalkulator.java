package com.project.MobileProgramming.khansamazaya;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class kalkulator extends AppCompatActivity {
    Spinner spinner;
    EditText angka1, angka2;
    Double a,b;
    String c,d;
    TextView hasil;
    Button hitung;
    double hasil_double;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);
        spinner = findViewById(R.id.opsi_operasi);
        hasil = findViewById(R.id.textHasil);
        c = angka1.getText().toString();
        d = angka2.getText().toString();
        angka1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                hitungHasil();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        angka2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                hitungHasil();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hitungHasil();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public Double perkalian(Double a, Double b) {
        return a*b;
    }
    public Double pembagian(Double a, Double b) {
        return a/b;
    }
    public Double penjumlahan(Double a, Double b) {
        return a+b;
    }
    public Double pengurangan(Double a, Double b) {
        return a-b;
    }

    public void hitungHasil(){
        if (!angka1.getText().toString().isEmpty() && !angka2.getText().toString().isEmpty()) {
            a = Double.parseDouble(angka1.getText().toString());
            b = Double.parseDouble(angka2.getText().toString());
            switch (spinner.getSelectedItemPosition()) {
                case 1:
                    hasil_double = perkalian(a, b);
                    hasil.setText(String.valueOf(hasil_double));
                    break;
                case 2:
                    hasil_double = pembagian(a, b);
                    hasil.setText(String.valueOf(hasil_double));
                    break;
                case 3:
                    hasil_double = penjumlahan(a, b);
                    hasil.setText(String.valueOf(hasil_double));
                    break;
                case 4:
                    hasil_double = pengurangan(a, b);
                    hasil.setText(String.valueOf(hasil_double));
                    break;
            }
        }else {
            Toast.makeText(kalkulator.this, "Mohon isi angka", Toast.LENGTH_SHORT).show();
            hasil.setText("0");
        }
    }
}