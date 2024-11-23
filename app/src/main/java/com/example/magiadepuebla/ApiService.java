package com.example.magiadepuebla;
import android.app.DownloadManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    // Obtener información de un pueblo
    @GET("pueblos/{nombre}")
    Call<modeloPueblo> getPueblo(@Path("nombre") String nombre);


    // Obtener actividades y festividades
    @GET("pueblos/{nombre}/festividades")
    Call<modeloActFes> getActividadesFestividades(@Path("nombre") String nombre);

    // Obtener hoteles y restaurantes
    @GET("pueblos/{nombre}/hoteles")
    Call<modeloHotRes> getHotelesRestaurantes(@Path("nombre") String nombre);

    @GET("pueblos")
    Call<List<modeloPueblo>> getPueblos();

}

