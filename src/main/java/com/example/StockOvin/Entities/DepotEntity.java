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

    @ManyToOne
    @JoinColumn(name = "adresse")
    private AdresseEntity adresse;


    private Date date_suppression;

    @ManyToOne
    @JoinColumn(name = "reference_vin")
    private VinEntity reference_vin;

    @ManyToOne
    @JoinColumn(name = "reference_fournisseur")
    private FournisseurEntity reference_fournisseur;


    public DepotEntity() {
    }

    public DepotEntity(String nom_depot, AdresseEntity adresse, VinEntity reference_vin, FournisseurEntity reference_fournisseur, Date date_suppression) {
        this.nom_depot = nom_depot;
        this.adresse = adresse;
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

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }

    public Date getDate_suppression() {
        return date_suppression;
    }

    public void setDate_suppression(Date date_suppression) {
        this.date_suppression = date_suppression;
    }

    public VinEntity getReference_vin() {
        return reference_vin;
    }

    public void setReference_vin(VinEntity reference_vin) {
        this.reference_vin = reference_vin;
    }

    public FournisseurEntity getReference_fournisseur() {
        return reference_fournisseur;
    }

    public void setReference_fournisseur(FournisseurEntity reference_fournisseur) {
        this.reference_fournisseur = reference_fournisseur;
    }
}
