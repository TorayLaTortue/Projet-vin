package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierReference;
    private String name;
    private Date orderCreationDate;
    private String wineQuality;
    @JoinColumn(name = "address")
    private int address;
    private Date deletion_date;

    // Default constructor
    public SupplierEntity() {
    }

    // Parameterized constructor
    public SupplierEntity(int supplierReference, String name, Date orderCreationDate, String wineQuality, int address, Date deletion_date) {
        this.supplierReference = supplierReference;
        this.name = name;
        this.orderCreationDate = orderCreationDate;
        this.wineQuality = wineQuality;
        this.address = address;
        this.deletion_date = deletion_date;
    }

    // Getters and Setters
    public int getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(int supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public String getWineQuality() {
        return wineQuality;
    }

    public void setWineQuality(String wineQuality) {
        this.wineQuality = wineQuality;
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
