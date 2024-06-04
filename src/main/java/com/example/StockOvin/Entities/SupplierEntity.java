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
    @ManyToOne
    @JoinColumn(name = "wine_reference")
    private WineEntity wine_reference;
    @ManyToOne
    @JoinColumn(name = "address")
    private AddressEntity address;
    private Date deletion_date;

    // Default constructor
    public SupplierEntity() {
    }

    // Parameterized constructor
    public SupplierEntity(int supplier_reference, String name, Date order_creation_date, WineEntity wine_reference, AddressEntity address, Date deletion_date) {
        this.supplier_reference = supplier_reference;
        this.name = name;
        this.order_creation_date = order_creation_date;
        this.wine_reference = wine_reference;
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

    public WineEntity getWine_reference() {
        return wine_reference;
    }
    public void setWine_reference(WineEntity wine_reference) {
        this.wine_reference = wine_reference;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Date getDeletionDate() {
        return deletion_date;
    }

    public void setDeletionDate(Date deletion_date) {
        this.deletion_date = deletion_date;
    }
}
