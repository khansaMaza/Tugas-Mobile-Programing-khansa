package com.project.MobileProgramming.khansamazaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MenuProgram extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    Fragment fragment;
    fragmentProgram fragmentProgram;
    BottomNavigationView bottomNavigationView;
    fragmentMahasiswa fragmentMahasiswa;
    fragmentKampus fragmentKampus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_program);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });
        bottomNavigationView = findViewById(R.id.nav);
        fragmentProgram = new fragmentProgram();
        fragmentMahasiswa = new fragmentMahasiswa();
        fragmentKampus = new fragmentKampus();
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.program);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.program) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentProgram).commit();
            return true;
        } else if (menuItem.getItemId() == R.id.mahasiswa) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentMahasiswa).commit();
            return true;
        } else if (menuItem.getItemId() == R.id.kampus) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentKampus).commit();
            return true;

        }
        return false;
    }
}