package com.example.magiadepuebla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;


public class conocerPuebloFragment extends Fragment {
    private int puebloId;

    public static conocerPuebloFragment newInstance(String nombrePueblo) {
        conocerPuebloFragment fragment = new conocerPuebloFragment();
        Bundle args = new Bundle();
        args.putString("nombre", nombrePueblo);  // Guardamos el nombre del pueblo en los argumentos
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conocer_pueblo, container, false);
        if (getArguments() != null) {
            String nombrePueblo = getArguments().getString("nombre");  // Recuperamos el nombre del pueblo
            obtenerDatosPueblo(nombrePueblo, view); // Llamamos al método para obtener los datos usando el nombre
        }
        return view;
    }

    private void obtenerDatosPueblo(String nombrePueblo, View view) {
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<modeloPueblo> call = apiService.getPueblo(nombrePueblo); // Usamos el nombre del pueblo
        call.enqueue(new Callback<modeloPueblo>() {
            @Override
            public void onResponse(Call<modeloPueblo> call, Response<modeloPueblo> response) {
                if (response.isSuccessful()) {
                    modeloPueblo pueblo = response.body();
                    if (pueblo != null) {
                        TextView tvTitulo = view.findViewById(R.id.tv_titulo1);
                        ImageView imageView = view.findViewById(R.id.imageView2);
                        tvTitulo.setText(pueblo.getNombre());
                        Glide.with(getContext())
                                .load(pueblo.getImagen()) // Asegúrate de que el campo imagen esté correcto
                                .into(imageView);
                    }
                } else {
                    Log.e("API", "Error en la respuesta: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<modeloPueblo> call, Throwable t) {
                Log.e("API", "Error de conexión: " + t.getMessage());
            }
        });
    }

}
