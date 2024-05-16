package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "adresse")
public class AdresseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int referenceadresse;
    private String ville;
    private String rue;
    private String code_postal;
    private Date date_suppression;

    public AdresseEntity() {
    }

    public AdresseEntity(int referenceadresse, String ville, String rue, String code_postal, Date date_suppression) {
        this.referenceadresse = referenceadresse;
        this.ville = ville;
        this.rue = rue;
        this.code_postal = code_postal;
        this.date_suppression = date_suppression;
    }

    public int getReferenceadresse() {
        return referenceadresse;
    }

    public void setReferenceadresse(int referenceadresse) {
        this.referenceadresse = referenceadresse;
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

    public String getcode_postal() {
        return code_postal;
    }

    public void setcode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public Date getdate_suppression() {
        return date_suppression;
    }

    public void setdate_suppression(Date date_suppression) {
        this.date_suppression = date_suppression;
    }
}