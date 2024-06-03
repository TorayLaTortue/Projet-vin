package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_reference;
    private String name;
    private Date order_creation_date;
    private String wine_quality;
    @JoinColumn(name = "address")
    private int address;
    private Date deletion_date;

    // Default constructor
    public SupplierEntity() {
    }

    // Parameterized constructor
    public SupplierEntity(int supplier_reference, String name, Date order_creation_date, String wine_quality, int address, Date deletion_date) {
        this.supplier_reference = supplier_reference;
        this.name = name;
        this.order_creation_date = order_creation_date;
        this.wine_quality = wine_quality;
        this.address = address;
        this.deletion_date = deletion_date;
    }

    // Getters and Setters
    public int getSupplierReference() {
        return supplier_reference;
    }

    public void setSupplierReference(int supplier_reference) {
        this.supplier_reference = supplier_reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderCreationDate() {
        return order_creation_date;
    }

    public void setOrderCreationDate(Date order_creation_date) {
        this.order_creation_date = order_creation_date;
    }

    public String getWineQuality() {
        return wine_quality;
    }

    public void setWineQuality(String wine_quality) {
        this.wine_quality = wine_quality;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public Date getdeletionDate() {
        return deletion_date;
    }

    public void setdeletionDate(Date deletion_date) {
        this.deletion_date = deletion_date;
    }
}
