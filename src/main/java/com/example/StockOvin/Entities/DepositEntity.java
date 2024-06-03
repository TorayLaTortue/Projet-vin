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
    @ManyToOne
    @JoinColumn(name = "address")
    private AddressEntity address;
    @ManyToOne
    @JoinColumn(name = "wine_reference")
    private WineEntity wine_reference;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "supplier_reference")
    private SupplierEntity supplier_reference;
    private Date deletion_date;


    public DepositEntity() {
    }

    public DepositEntity(String deposit_name, AddressEntity address, WineEntity wine_reference, int quantity, SupplierEntity supplier_reference, Date deletion_date) {
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

    public WineEntity getWineReference() {
        return wine_reference;
    }

    public void setWineReference(WineEntity wine_reference) {
        this.wine_reference = wine_reference;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SupplierEntity getSupplierReference() {
        return supplier_reference;
    }

    public void setSupplierReference(SupplierEntity supplier_reference) {
        this.supplier_reference = supplier_reference;
    }
}
