package com.project.MobileProgramming.khansamazaya;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthenticationManager {
    private FirebaseAuth auth;



    public AuthenticationManager() {
        auth = FirebaseAuth.getInstance();
    }

    public void signInWithEmailAndPassword(String email, String password, OnCompleteListener<AuthResult> listener) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(listener);
    }

    public FirebaseUser getCurrentUser(){
        return auth.getCurrentUser();
    }
}
