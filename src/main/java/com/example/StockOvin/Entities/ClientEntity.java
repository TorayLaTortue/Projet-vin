package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

    @Entity
    @Table(name = "client")
    public class ClientEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int reference_client;
        private String nom;
        private String prenom;
        private String mail;
        private String telephone;
        @Schema(name = "mot_de_passe")
        private String mot_de_passe;
        private String role;
        @Schema(name = "date_suppression")
        private Date date_suppression;

    public ClientEntity() {
    }

        public ClientEntity(int reference_client, String nom, String prenom, String mail, String telephone, String mot_de_passe, String role, Date date_suppression) {
            this.reference_client = reference_client;
            this.nom = nom;
            this.prenom = prenom;
            this.mail = mail;
            this.telephone = telephone;
            this.mot_de_passe = mot_de_passe;
            this.role = role;
            this.date_suppression = date_suppression;
        }

        public int getReference_client() {
            return reference_client;
        }
        public void setReference_client(int reference_client) {
            this.reference_client = reference_client;
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

        @Schema(name = "mot_de_passe")
        public String getmotDePasse() {
            return mot_de_passe;
        }
        public void setmotDePasse(String mot_de_passe) {
            this.mot_de_passe = mot_de_passe;
        }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

        public Date getdate_suppression() {
            return date_suppression;
        }

        public void setdate_suppression(Date date_suppression) {
            this.date_suppression = date_suppression;
        }
    }