package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "depot")
public class DepotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference_depot;
    private String nom_depot;
    private Date date_suppression;
    private int reference_vin;
    private int reference_fournisseur;

    public DepotEntity() {
    }

    public DepotEntity(int reference_depot, String nom_depot, Date date_suppression, int reference_vin, int reference_fournisseur) {
        this.reference_depot = reference_depot;
        this.nom_depot = nom_depot;
        this.date_suppression = date_suppression;
        this.reference_vin = reference_vin;
        this.reference_fournisseur = reference_fournisseur;


    }

    public int getReference_depot() {
        return reference_depot;
    }

    public void setReference_depot(int reference_depot) {
        this.reference_depot = reference_depot;
    }

    public String getNom_depot() {
        return nom_depot;
    }

    public void setNom_depot(String nom_depot) {
        this.nom_depot = nom_depot;
    }

    public Date getDate_suppression() {
        return date_suppression;
    }

    public void setDate_suppression(Date date_suppression) {
        this.date_suppression = date_suppression;
    }

    public int getReference_vin() {
        return reference_vin;
    }

    public void setReference_vin(int reference_vin) {
        this.reference_vin = reference_vin;
    }

    public int getReference_fournisseur() {
        return reference_fournisseur;
    }

    public void setReference_fournisseur(int reference_fournisseur) {
        this.reference_fournisseur = reference_fournisseur;
    }
}