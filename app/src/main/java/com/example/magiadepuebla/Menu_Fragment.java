package com.example.magiadepuebla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Menu_Fragment extends Fragment {

    public Menu_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_, container, false);

        LinearLayout atlixto = view.findViewById(R.id.atlixto);
        atlixto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new conoceratlixcoFragment());
            }
        });

        LinearLayout chignahuapan = view.findViewById(R.id.chignahuapan);
        chignahuapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new conocerChignahuapanFragment());
            }
        });

        LinearLayout cholula = view.findViewById(R.id.cholula);
        cholula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new conocerCholulaFragment());
            }
        });

        return view;

    }

    private void abrirFragmento(Fragment fragmentoDestino) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragmentoDestino);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}



