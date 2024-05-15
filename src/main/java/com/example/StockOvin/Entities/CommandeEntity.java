package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "commande")
public class CommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int referenceCommande;
    private int referenceClient;
    private int adresseFacturation;
    private int adresseLivraison;
    private String statut;
    private Date dateCreationCommande;
    private int referenceVin;
    private int quantiteProduit;
    private Date dateSuppression;

    public CommandeEntity() {
    }

    public CommandeEntity(int referenceCommande, int referenceClient, int adresseFacturation, int adresseLivraison,
                        String statut, Date dateCreationCommande, int referenceVin, int quantiteProduit, Date dateSuppression) {
        this.referenceCommande = referenceCommande;
        this.referenceClient = referenceClient;
        this.adresseFacturation = adresseFacturation;
        this.adresseLivraison = adresseLivraison;
        this.statut = statut;
        this.dateCreationCommande = dateCreationCommande;
        this.referenceVin = referenceVin;
        this.quantiteProduit = quantiteProduit;
        this.dateSuppression = dateSuppression;

    }

    public int getreferenceCommande() {
        return referenceCommande;
    }

    public void setreferenceCommande(int referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

    public int getreferenceClient() {
        return referenceClient;
    }

    public void setreferenceClient(int referenceClient) {
        this.referenceClient = referenceClient;
    }

    public int getadresseFacturation() {
        return adresseFacturation;
    }

    public void setadresseFacturation(int adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public int getAdresselivraison() {
        return adresseLivraison;
    }

    public void setAdresselivraison(int adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateCreationCommande() {
        return dateCreationCommande;
    }

    public void setDateCreationCommande(Date dateCreationCommande) {
        this.dateCreationCommande = dateCreationCommande;
    }

    public int getReferenceVin() {
        return referenceVin;
    }

    public void setReferenceVin(int referenceVin) {
        this.referenceVin = referenceVin;
    }

    public int getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }
}