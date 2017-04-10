package com.programacion.robertomtz.fragmentosapp;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rmartinezm on 09/04/2017.
 */

public class Timeline {

    @SerializedName("timeline")
    private ArrayList<Historia> historias;
    private int status;

    public Timeline(int status, ArrayList<Historia> historias) {
        this.status = status;
        this.historias = historias;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Historia> getHistorias() {
        return historias;
    }

    public void setHistorias(ArrayList<Historia> historias) {
        this.historias = historias;
    }

    public static Historia parseJSON(String json){
        Gson gson = new Gson();
        Historia historia = gson.fromJson(json, Historia.class);
        return historia;
    }
}
