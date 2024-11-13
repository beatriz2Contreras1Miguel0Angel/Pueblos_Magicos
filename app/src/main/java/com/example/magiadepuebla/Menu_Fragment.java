package com.example.magiadepuebla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Menu_Fragment extends Fragment {

    public Menu_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del Fragment
        View rootView = inflater.inflate(R.layout.fragment_menu_, container, false);

        // Obtener el contenedor donde se agregarán los botones
        LinearLayout botonContainer = rootView.findViewById(R.id.botonContainer);

        // Crear y agregar 10 botones dinámicamente
        for (int i = 1; i <= 10; i++) {
            Button boton = new Button(getActivity());  // Usamos getActivity() para obtener el contexto

            // Establecer el texto del botón
            boton.setText("Botón " + i);

            // Establecer la imagen del botón (diferente para cada uno)
            switch (i) {
                case 1:
                    boton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atlixco, 0, 0, 0);
                    break;
                case 2:
                    boton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.chignahuapan, 0, 0, 0);
                    break;
                case 3:
                    boton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cholula, 0, 0, 0);
                    break;
                // Añadir más casos para otros botones con sus respectivas imágenes
                default:
                    boton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atlixco, 0, 0, 0);
                    break;
            }

            // Establecer un padding para separar la imagen del texto
            boton.setCompoundDrawablePadding(16);  // Ajusta el valor del padding según tu necesidad

            // Establecer el tamaño de los botones (opcional)
            boton.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            // Agregar un OnClickListener para cada botón
            int finalI = i;
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica al hacer clic en el botón
                    Toast.makeText(getActivity(), "Botón " + finalI + " presionado", Toast.LENGTH_SHORT).show();
                }
            });

            // Agregar el botón al contenedor
            botonContainer.addView(boton);
        }

        return rootView;  // Devolvemos la vista inflada
    }

}