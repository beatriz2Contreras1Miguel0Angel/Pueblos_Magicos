package com.example.magiadepuebla;
import com.google.gson.annotations.SerializedName;

public class modeloPueblo {
    private String nombre;
    private String viveMagia;
    private String motivo;
    private String imagen;
    private String video;

    public modeloPueblo() {
    }

    public modeloPueblo(String nombre, String viveMagia, String motivo, String imagen, String video) {
        this.nombre = nombre;
        this.viveMagia = viveMagia;
        this.motivo = motivo;
        this.imagen = imagen;
        this.video = video;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getViveMagia() {
        return viveMagia;
    }

    public void setViveMagia(String viveMagia) {
        this.viveMagia = viveMagia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
