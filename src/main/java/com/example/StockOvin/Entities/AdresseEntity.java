package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "adresse")
public class AdresseEntity {
    public Integer setReference_adresse;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference_adresse;
    private String ville;
    private String rue;
    private String code_postal;
    private Date date_suppression;

    public AdresseEntity() {
    }

    public AdresseEntity(int reference_adresse, String ville, String rue, String code_postal, Date date_suppression) {
        this.reference_adresse = reference_adresse;
        this.ville = ville;
        this.rue = rue;
        this.code_postal = code_postal;
        this.date_suppression = date_suppression;
    }

    public int getReference_adresse() {
        return reference_adresse;
    }

    public void setReference_adresse(int reference_adresse) {
        this.reference_adresse = reference_adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public Date getDate_suppression() {
        return date_suppression;
    }

    public void setDate_suppression(Date date_suppression) {
        this.date_suppression = date_suppression;
    }
}