package com.example.StockOvin.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_reference;
    private String city;
    private String street;
    private String postal_code;
    private Date deletion_date;

    public AddressEntity() {
    }

    public AddressEntity(int address_reference, String city, String street, String postal_code, Date deletion_date) {
        this.address_reference = address_reference;
        this.city = city;
        this.street = street;
        this.postal_code = postal_code;
        this.deletion_date = deletion_date;
    }

    public int getAdressReference() {
        return address_reference;
    }

    public void setAdressReference(int address_reference) {
        this.address_reference = address_reference;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public Date getDate_suppression() {
        return deletion_date;
    }

    public void setDate_suppression(Date deletion_date) {
        this.deletion_date = deletion_date;
    }
}