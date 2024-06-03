package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;



    @Entity
    @Table(name = "client")
    public class ClientEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int client_reference;
        private String name;
        private String first_name;
        private String email;
        private String phone;
        private String password;
        private String role;
        private Date deletion_date;

    public ClientEntity() {
    }

    public ClientEntity(int client_reference, String name, String first_name, String email, String phone, String password, String role, Date deletion_date) {
        this.client_reference = client_reference;
        this.name = name;
        this.first_name = first_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.deletion_date = deletion_date;
    }

    public int getClient_reference() {
        return client_reference;
    }
    public void setClient_reference(int client_reference) {
        this.client_reference = client_reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMot_de_passe() {
        return password;
    }

    public void setMot_de_passe(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDate_suppression() {
        return deletion_date;
    }

    public void setDate_suppression(Date deletion_date) {
        this.deletion_date = deletion_date;
    }
    }