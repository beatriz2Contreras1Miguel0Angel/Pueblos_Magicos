package com.example.magiadepuebla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class conoceratlixcoFragment extends Fragment {

    public conoceratlixcoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conocer_atlixco, container, false);

        LinearLayout vive = view.findViewById(R.id.viveMagia);
        vive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new atlixcoViveFragment());
            }
        });

        LinearLayout actividades = view.findViewById(R.id.actividades);
        actividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new AtractivoAtixcoFragment());
            }
        });

        LinearLayout comida = view.findViewById(R.id.comida);
        comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new comidaAtlixcoFragment());
            }
        });

        LinearLayout hotel = view.findViewById(R.id.hotel);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new hospedajeAtlixcoFragment());
            }
        });

        LinearLayout festividad = view.findViewById(R.id.festivida);
        festividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new festividadesAtlixcoFragment());
            }
        });

        LinearLayout ruta = view.findViewById(R.id.ruta);
        ruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento(new rutaAtlixcoFragment());
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