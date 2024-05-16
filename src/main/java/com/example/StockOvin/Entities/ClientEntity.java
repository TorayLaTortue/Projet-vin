package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int referenceclient;

    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String role;
    private Date date_suppression;
    private String mot_de_passe;

    public ClientEntity() {
    }

    public ClientEntity(String nom, String prenom, String mail, String telephone, String role, Date date_suppression, String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.role = role;
        this.date_suppression = date_suppression;
        this.mot_de_passe = mot_de_passe;

    }

    public int getReferenceclient() {
        return referenceclient;
    }

    public void setReferenceclient(int referenceclient) {
        this.referenceclient = referenceclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDatesuppression() {
        return date_suppression;
    }

    public void setdate_suppression(Date date_suppression) {
        this.date_suppression = date_suppression;
    }

    public void setmot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getmot_de_passe() {
        return mot_de_passe;
    }
}