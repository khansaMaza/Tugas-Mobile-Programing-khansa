package com.project.MobileProgramming.khansamazaya;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class fragmentProgram extends Fragment {
    Button btnLogout;
    SessionManager sessionManager;
    FirebaseAuth auth;
    private FirebaseFirestore db;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_program, container, false);

        db = FirebaseFirestore.getInstance();
        sessionManager = new SessionManager(requireActivity().getApplicationContext());
        auth = FirebaseAuth.getInstance();

        MaterialButton button1 = view.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), scrollview.class));
            }
        });
        MaterialButton button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WebView.class));
            }
        });
        MaterialButton button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), kalkulator.class));
            }
        });
        MaterialButton button4 = view.findViewById(R.id.bebas);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), konversi_satuan.class));
            }
        });
        MaterialButton logot = view.findViewById(R.id.log_out);
        logot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logout();
                sessionManager.setLogInStatus(false);
                startActivity(new Intent(getActivity(), login_page.class));
            }
        });

        return view;
    }
}