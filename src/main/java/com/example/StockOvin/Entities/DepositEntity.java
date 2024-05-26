package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deposit")
public class DepositEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deposit_reference;

    private String deposit_name;

    @JoinColumn(name = "address")
    private int address;

    private Date deletion_date;

    
    @JoinColumn(name = "wine_reference")
    private int wine_reference;

    private int quantity;

    
    @JoinColumn(name = "supplier_reference")
    private int supplier_reference;


    public DepositEntity() {
    }

    public DepositEntity(String deposit_name, int address, int wine_reference, int quantity, int supplier_reference, Date deletion_date) {
        this.deposit_name = deposit_name;
        this.address = address;
        this.deletion_date = deletion_date;
        this.wine_reference = wine_reference;
        this.quantity = quantity;
        this.supplier_reference = supplier_reference;
    }

    public int getDepositReference() {
        return deposit_reference;
    }

    public void setDepositReference(int deposit_reference) {
        this.deposit_reference = deposit_reference;
    }

    public String getNameDeposit() {
        return deposit_name;
    }

    public void setNameDeposit(String deposit_name) {
        this.deposit_name = deposit_name;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public Date getDeletionDate() {
        return deletion_date;
    }

    public void setDeletionDate(Date deletion_date) {
        this.deletion_date = deletion_date;
    }

    public int getWineReference() {
        return wine_reference;
    }

    public void setWineReference(int wine_reference) {
        this.wine_reference = wine_reference;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSupplierReference() {
        return supplier_reference;
    }

    public void setSupplierReference(int supplier_reference) {
        this.supplier_reference = supplier_reference;
    }
}
