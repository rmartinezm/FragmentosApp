package com.programacion.robertomtz.fragmentosapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rmartinezm on 09/04/2017.
 */

public class Historia {

    private String user;
    @SerializedName("content_title")
    private String title;
    @SerializedName("content_text")
    private String text;
    private String image;

    public Historia(String user, String title, String text, String image) {
        this.user = user;
        this.title = title;
        this.text = text;
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
