package com.project.MobileProgramming.khansamazaya;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private Context context;
    private SharedPreferences sharedPreferences;
    FirebaseAuth auth;
    private final FirebaseFirestore db;

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE);
        db = FirebaseFirestore.getInstance();
        this.context = context;
    }



    public void setLogInStatus(boolean isLoggedIn){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }

    public void logout(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("session_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("logged_in", false);
        editor.apply();
        FirebaseAuth.getInstance().signOut();
    }
}
