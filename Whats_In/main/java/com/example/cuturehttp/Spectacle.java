package com.example.cuturehttp;

public class Spectacle {

    private String nom;
    private String date;
    private String heure;
    private String image;
    private String webLien;
    private String lieu;


    public Spectacle(String name, String date, String heure,String image,String lieu,String webLien) {
        this.nom = name;
        this.date = date;
        this.heure = heure;
        this.image = image;
        this.lieu = lieu;
        this.webLien = webLien;
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

    public String getWebLien() {
        return webLien;
    }

    public String getLieu() {
        return lieu;
    }
}
