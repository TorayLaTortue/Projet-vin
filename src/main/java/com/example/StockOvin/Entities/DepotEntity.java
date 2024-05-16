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

    public int getreference_depot() {
        return reference_depot;
    }

    public void setreference_depot(int reference_depot) {
        this.reference_depot = reference_depot;
    }

    public String getnom_depot() {
        return nom_depot;
    }

    public void setnom_depot(String nom_depot) {
        this.nom_depot = nom_depot;
    }

    public Date getdate_suppression() {
        return date_suppression;
    }

    public void setdate_suppression(Date date_suppression) {
        this.date_suppression = date_suppression;
    }

    public int getreference_vin() {
        return reference_vin;
    }

    public void setreference_vin(int reference_vin) {
        this.reference_vin = reference_vin;
    }

    public int getreference_fournisseur() {
        return reference_fournisseur;
    }

    public void setreference_fournisseur(int reference_fournisseur) {
        this.reference_fournisseur = reference_fournisseur;
    }
}