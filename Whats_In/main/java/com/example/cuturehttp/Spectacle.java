package com.example.cuturehttp;

public class Spectacle {

    private String nom;
    private String date;
    private String heure;


    public Spectacle(String name, String date, String heure) {
        this.nom = name;
        this.date = date;
        this.heure = heure;
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
}
