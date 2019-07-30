package com.example.cuturehttp;

public class Spectacle {

    private String nom;
    private String date;
    private String heure;
    private String image;
    private String webLien;
    private String lieu;
    private String description;


    public Spectacle(String name, String date, String heure,String image,String lieu,String webLien,String description) {
        this.nom = name;
        this.date = date;
        this.heure = heure;
        this.image = image;
        this.lieu = lieu;
        this.webLien = webLien;
        this.description = description;
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

    public String getDescription() {
        return description;
    }
}
