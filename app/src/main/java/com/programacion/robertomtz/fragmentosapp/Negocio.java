package com.programacion.robertomtz.fragmentosapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rmartinezm on 10/04/2017.
 */

public class Negocio {

    @SerializedName("name")
    private String nombre;
    @SerializedName("image")
    private String imagen;
    @SerializedName("lat")
    private double latitud;
    @SerializedName("lon")
    private double longitud;

    public Negocio(String nombre, String imagen, String latitud, String longitud) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.latitud = Double.parseDouble(latitud);
        this.longitud = Double.parseDouble(longitud);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
