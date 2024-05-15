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
    private String codepostal;
    private Date datesuppression;

    public AdresseEntity() {
    }

    public AdresseEntity(int referenceadresse, String ville, String rue, String codepostal, Date datesuppression) {
        this.referenceadresse = referenceadresse;
        this.ville = ville;
        this.rue = rue;
        this.codepostal = codepostal;
        this.datesuppression = datesuppression;
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

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public Date getDatesuppression() {
        return datesuppression;
    }

    public void setDatesuppression(Date datesuppression) {
        this.datesuppression = datesuppression;
    }
}