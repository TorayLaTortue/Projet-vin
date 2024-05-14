package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "commande")
public class CommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int referencecommande;
    private int referenceclient;
    private int adressefacturation;
    private int adresselivraison;
    private String statut;
    private Date datecreationcommande;
    private int referencevin;
    private int quantiteproduit;
    private Date datesuppression;

    public CommandeEntity() {
    }

    public CommandeEntity(int referencecommande, int referenceclient, int adressefacturation, int adresselivraison,
                        String statue, Date datecreationcommande, int referencevin, int quantiteproduit, Date datesuppression) {
        this.referencecommande = referencecommande;
        this.referenceclient = referenceclient;
        this.adressefacturation = adressefacturation;
        this.adresselivraison = adresselivraison;
        this.statut = statut;
        this.datecreationcommande = datecreationcommande;
        this.referencevin = referencevin;
        this.quantiteproduit = quantiteproduit;
        this.datesuppression = datesuppression;

    }

    public int getReferencecommande() {
        return referencecommande;
    }

    public void setReferencecommande(int referencecommande) {
        this.referencecommande = referencecommande;
    }

    public int getReferenceclient() {
        return referenceclient;
    }

    public void setReferenceclient(int referenceclient) {
        this.referenceclient = referenceclient;
    }

    public int getAdressefacturation() {
        return adressefacturation;
    }

    public void setAdressefacturation(int adressefacturation) {
        this.adressefacturation = adressefacturation;
    }

    public int getAdresselivraison() {
        return adresselivraison;
    }

    public void setAdresselivraison(int adresselivraison) {
        this.adresselivraison = adresselivraison;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDatecreationcommande() {
        return datecreationcommande;
    }

    public void setDatecreationcommande(Date datecreationcommande) {
        this.datecreationcommande = datecreationcommande;
    }

    public int getReferencevin() {
        return referencevin;
    }

    public void setReferencevin(int referencevin) {
        this.referencevin = referencevin;
    }

    public int getQuantiteproduit() {
        return quantiteproduit;
    }

    public void setQuantiteproduit(int quantiteproduit) {
        this.quantiteproduit = quantiteproduit;
    }

    public Date getDatesuppression() {
        return datesuppression;
    }

    public void setDatesuppression(Date datesuppression) {
        this.datesuppression = datesuppression;
    }
}