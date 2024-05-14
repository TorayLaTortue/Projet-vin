package com.example.StockOvin.Models;

import java.util.Date;

public class ClientModels {

    private int referenceClient;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String role;
    private Date DateSupression;


    public ClientModels(int referenceClient, String nom, String prenom, String telephone, String role, Date DateSuprresion) {
        this.referenceClient = referenceClient;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.role = role;
        this.DateSupression = DateSuprresion;
    }

    public int getReferenceClient() {
        return referenceClient;
    }
    public void setReferenceClient(int referenceClient) {
        this.referenceClient = referenceClient;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getPrenom() {
        return prenom;
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

    public Date getDateSupression() {
        return DateSupression;
    }
    public void setDateSupression(Date dateSupression) {
        DateSupression = dateSupression;
    }
    
}
