package com.example.StockOvin.Entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "vin")
public class VinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference_vin;

    private String nom;
    private String image;
    private String region;
    private String famille;
    private Date annee;
    private int quantite;
    private String format;
    private float promotion;
    private int prix;
    private Date date_suppression;

    // Constructeur
    public VinEntity(int reference_vin, String nom, String image, String region, String famille, Date annee, int quantite, String format, float promotion, int prix, Date date_suppression) {
        this.reference_vin = reference_vin;
        this.nom = nom;
        this.image = image;
        this.region = region;
        this.famille = famille;
        this.annee = annee;
        this.quantite = quantite;
        this.format = format;
        this.promotion = promotion;
        this.prix = prix;
        this.date_suppression = date_suppression;
    }

    // Constructeur vide
    public VinEntity() {
    }

    // Getters et Setters
    public int getReference_vin() {
        return reference_vin;
    }

    public void setReference_vin(int reference_vin) {
        this.reference_vin = reference_vin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public float getPromotion() {
        return promotion;
    }

    public void setPromotion(float promotion) {
        this.promotion = promotion;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDate_suppression() {
        return date_suppression;
    }

    public void setDate_suppression(Date date_suppression) {
        this.date_suppression = date_suppression;
    }
}
