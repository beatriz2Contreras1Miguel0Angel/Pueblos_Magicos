package com.example.magiadepuebla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;


public class Menu_Fragment extends Fragment {

    public Menu_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_, container, false);

        //1
        LinearLayout atlixto = view.findViewById(R.id.atlixto);
        atlixto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenemos el nombre del pueblo por su ID
                String nombrePueblo = obtenerNombrePuebloPorId(1); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo)); // Pasamos el nombre del pueblo
            }
        });
        //2
        LinearLayout chignahuapan = view.findViewById(R.id.chignahuapan);
        chignahuapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(2); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });
        //3
        LinearLayout cholula = view.findViewById(R.id.cholula);
        cholula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(3); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout cuetzalan = view.findViewById(R.id.cuetzalan);
        cuetzalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(4); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout huauchinango = view.findViewById(R.id.huauchinango);
        huauchinango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(5); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout huejotzingo = view.findViewById(R.id.huejotzingo);
        huejotzingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(6); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout pahuatlan = view.findViewById(R.id.pahuatlan);
        pahuatlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(7); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout tetela = view.findViewById(R.id.tetela);
        tetela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(8); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout teziutlan = view.findViewById(R.id.teziutlan);
        teziutlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(9); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout tlatlauquitepec = view.findViewById(R.id.tlatlauquitepec);
        tlatlauquitepec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(10); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout xicotepec = view.findViewById(R.id.xicotepec);
        xicotepec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(11); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });

        LinearLayout zacatlan = view.findViewById(R.id.zacatlan);
        zacatlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePueblo = obtenerNombrePuebloPorId(12); // El id "1" corresponde a Atlixco
                abrirFragmento(conocerPuebloFragment.newInstance(nombrePueblo));
            }
        });
        return view;
    }

    private void abrirFragmento(Fragment fragmentoDestino) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragmentoDestino);
        fragmentTransaction.addToBackStack(null);  // Permite retroceder al fragmento anterior
        fragmentTransaction.commit();
    }

    private String obtenerNombrePuebloPorId(int puebloId) {
        Map<Integer, String> puebloNombres = new HashMap<>();
        puebloNombres.put(1, "atlixco");
        puebloNombres.put(2, "chignahuapan");
        puebloNombres.put(3, "cholula");
        puebloNombres.put(4, "cuetzalan");
        puebloNombres.put(5, "huauchinango");
        puebloNombres.put(6, "huejotzingo");
        puebloNombres.put(7, "pahuatlan");
        puebloNombres.put(8, "tetela");
        puebloNombres.put(9, "teziutlan");
        puebloNombres.put(10, "tlatlauquitepec");
        puebloNombres.put(11, "xicotepec");
        puebloNombres.put(12, "zacatlan");

        return puebloNombres.get(puebloId); // Devuelve el nombre correspondiente al ID
    }

}



