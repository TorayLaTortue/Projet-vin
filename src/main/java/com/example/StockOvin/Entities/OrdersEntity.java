package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_reference")
    private int order_reference;
    @ManyToOne
    @JoinColumn(name = "client_reference")
    private ClientEntity client_reference;
    @ManyToOne
    @JoinColumn(name = "billing_address")
    private AddressEntity billing_address;
    @ManyToOne
    @JoinColumn(name = "delivery_address")
    private AddressEntity delivery_address;
    @ManyToOne
    @JoinColumn(name = "wine_reference")
    private WineEntity wine_reference;

    @Column(name = "quantity_product")
    private Integer quantity_product;

    @Column(name = "status")
    private String status;

    @Column(name = "order_creation_date")
    private LocalDate order_creation_date;

    // Constructor
    public OrdersEntity() {}

    public OrdersEntity(int order_reference, ClientEntity client_reference, AddressEntity billing_address, AddressEntity delivery_address, WineEntity wine_reference, Integer quantity_product, String status, LocalDate order_creation_date) {
        this.order_reference = order_reference;
        this.client_reference = client_reference;
        this.billing_address = billing_address;
        this.delivery_address = delivery_address;
        this.wine_reference = wine_reference;
        this.quantity_product = quantity_product;
        this.status = status;
        this.order_creation_date = order_creation_date;
    }

    // Getters and Setters in camel case
    public int getOrderReference() {
        return order_reference;
    }

    public void setOrderReference(int order_reference) {
        this.order_reference = order_reference;
    }

    public ClientEntity getClientReference() {
        return client_reference;
    }

    public void setClientReference(ClientEntity client_reference) {
        this.client_reference = client_reference;
    }

    public AddressEntity getBillingAddress() {
        return billing_address;
    }

    public void setBillingAddress(AddressEntity billing_address) {
        this.billing_address = billing_address;
    }

    public AddressEntity getDeliveryAddress() {
        return delivery_address;
    }

    public void setDeliveryAddress(AddressEntity delivery_address) {
        this.delivery_address = delivery_address;
    }

    public WineEntity getWineReference() {
        return wine_reference;
    }

    public void setWineReference(WineEntity wine_reference) {
        this.wine_reference = wine_reference;
    }

    public Integer getQuantityProduct() {
        return quantity_product;
    }

    public void setQuantityProduct(Integer quantity_product) {
        this.quantity_product = quantity_product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderCreationDate() {
        return order_creation_date;
    }

    public void setOrderCreationDate(LocalDate order_creation_date) {
        this.order_creation_date = order_creation_date;
    }
}
