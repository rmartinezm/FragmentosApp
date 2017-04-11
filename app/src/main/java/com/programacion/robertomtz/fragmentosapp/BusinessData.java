package com.programacion.robertomtz.fragmentosapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rmartinezm on 09/04/2017.
 */

public class BusinessData {

    @SerializedName("business_data")
    private ArrayList<Negocio> negocios;

    public BusinessData(ArrayList<Negocio> negocios) {
        this.negocios = negocios;
    }

    public ArrayList<Negocio> getNegocios() {
        return negocios;
    }

    public void setNegocios(ArrayList<Negocio> negocios) {
        this.negocios = negocios;
    }

    public static Negocio parseJSON(String json){
        Gson gson = new GsonBuilder().create();
        Negocio negocio = gson.fromJson(json, Negocio.class);
        return negocio;
    }
}
