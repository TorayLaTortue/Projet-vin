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
        private String commande;
        private String role;
        private Date datesuppression;

        public ClientEntity() {
        }

        public ClientEntity(String nom, String prenom, String mail, String telephone, String commande, String role, Date datesuppression) {
            this.nom = nom;
            this.prenom = prenom;
            this.mail = mail;
            this.telephone = telephone;
            this.commande = commande;
            this.role = role;
            this.datesuppression = datesuppression;

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

        public String getCommande() {
            return commande;
        }

        public void setCommande(String commande) {
            this.commande = commande;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Date getDatesuppression() {
            return datesuppression;
        }

        public void setDatesuppression(Date datesuppression) {
            this.datesuppression = datesuppression;
        }
    }