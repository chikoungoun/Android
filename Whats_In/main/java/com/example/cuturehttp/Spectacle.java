package com.example.cuturehttp;

public class Spectacle {

    private String nom;
    private String date;
    private String heure;
    private String image;


    public Spectacle(String name, String date, String heure,String image) {
        this.nom = name;
        this.date = date;
        this.heure = heure;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getImage() {
        return image;
    }
}
