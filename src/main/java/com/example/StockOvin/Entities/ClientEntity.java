package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

    @Entity
    @Table(name = "client")
    public class ClientEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        
        private String nom;
        private String prenom;
        private String mail;
        private String telephone;
        private String motDePasse;
        private String role;
        private Date dateSuppression;

        public ClientEntity() {
        }

        public ClientEntity(String nom, String prenom, String mail, String telephone, String motDePasse, String role, Date dateSuppression) {
            this.nom = nom;
            this.prenom = prenom;
            this.mail = mail;
            this.telephone = telephone;
            this.motDePasse = motDePasse;
            this.role = role;
            this.dateSuppression = dateSuppression;
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

        public String getMotDePasse() {
            return motDePasse;
        }
        public void setMotDePasse(String motDePasse) {
            this.motDePasse = motDePasse;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Date getdateSuppression() {
            return dateSuppression;
        }

        public void setdateSuppression(Date dateSuppression) {
            this.dateSuppression = dateSuppression;
        }
    }