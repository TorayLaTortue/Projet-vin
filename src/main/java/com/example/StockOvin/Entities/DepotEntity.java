package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "depot")
public class DepotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int referencedepot;
    private String nomdepot;
    private Date datesuppression;
    private int referencevin;
    private int referencefournisseur;

    public DepotEntity() {
    }

    public DepotEntity(int referencedepot, String nomdepot, Date datesuppression, int referencevin, int referencefournisseur) {
        this.referencedepot = referencedepot;
        this.nomdepot = nomdepot;
        this.datesuppression = datesuppression;
        this.referencevin = referencevin;
        this.referencefournisseur = referencefournisseur;


    }

    public int getReferencedepot() {
        return referencedepot;
    }

    public void setReferencedepot(int referencedepot) {
        this.referencedepot = referencedepot;
    }

    public String getNomdepot() {
        return nomdepot;
    }

    public void setNomdepot(String nomdepot) {
        this.nomdepot = nomdepot;
    }

    public Date getDatesuppression() {
        return datesuppression;
    }

    public void setDatesuppression(Date datesuppression) {
        this.datesuppression = datesuppression;
    }

    public int getReferencevin() {
        return referencevin;
    }

    public void setReferencevin(int referencevin) {
        this.referencevin = referencevin;
    }

    public int getReferencefournisseur() {
        return referencefournisseur;
    }

    public void setReferencefournisseur(int referencefournisseur) {
        this.referencefournisseur = referencefournisseur;
    }
}