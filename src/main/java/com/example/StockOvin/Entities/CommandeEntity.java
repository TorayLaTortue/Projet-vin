package com.example.StockOvin.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "commande")
public class CommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference_commande;
    private int reference_client;
    private int adresse_factuation;
    private int adresse_livraison;
    private String statut;
    private Date date_creation_commande;
    private int reference_vin;
    private int quantite_produit;
    private Date date_suppression;

    public CommandeEntity() {
    }

    public CommandeEntity(int reference_commande, int reference_client, int adresse_factuation, int adresse_livraison,
            String statut, Date date_creation_commande, int reference_vin, int quantite_produit, Date date_suppression) {
        this.reference_commande = reference_commande;
        this.reference_client = reference_client;
        this.adresse_factuation = adresse_factuation;
        this.adresse_livraison = adresse_livraison;
        this.statut = statut;
        this.date_creation_commande = date_creation_commande;
        this.reference_vin = reference_vin;
        this.quantite_produit = quantite_produit;
        this.date_suppression = date_suppression;

    }

    public int getreference_commande() {
        return reference_commande;
    }

    public void setreference_commande(int reference_commande) {
        this.reference_commande = reference_commande;
    }

    public int getreference_client() {
        return reference_client;
    }

    public void setreference_client(int reference_client) {
        this.reference_client = reference_client;
    }

    public int getadresse_factuation() {
        return adresse_factuation;
    }

    public void setadresse_factuation(int adresse_factuation) {
        this.adresse_factuation = adresse_factuation;
    }

    public int getadresse_livraison() {
        return adresse_livraison;
    }

    public void setadresse_livraison(int adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getdate_creation_commande() {
        return date_creation_commande;
    }

    public void setdate_creation_commande(Date date_creation_commande) {
        this.date_creation_commande = date_creation_commande;
    }

    public int getreference_vin() {
        return reference_vin;
    }

    public void setreference_vin(int reference_vin) {
        this.reference_vin = reference_vin;
    }

    public int getquantite_produit() {
        return quantite_produit;
    }

    public void setquantite_produit(int quantite_produit) {
        this.quantite_produit = quantite_produit;
    }

    public Date getdate_suppression() {
        return date_suppression;
    }

    public void setdate_suppression(Date date_suppression) {
        this.date_suppression = date_suppression;
    }
}