package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_reference")
    private Long order_reference;

    @Column(name = "client_reference")
    private Long client_reference;

    @Column(name = "billing_address")
    private Long billing_address;

    @Column(name = "delivery_address")
    private Long delivery_address;

    @Column(name = "wine_reference")
    private Long wine_reference;

    @Column(name = "quantity_product")
    private Integer quantity_product;

    @Column(name = "status")
    private String status;

    @Column(name = "order_creation_date")
    private LocalDate order_creation_date;

    // Constructor
    public OrderEntity() {}

    public OrderEntity(Long order_reference, Long client_reference, Long billing_address, Long delivery_address, Long wine_reference, Integer quantity_product, String status, LocalDate order_creation_date) {
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
    public Long getOrderReference() {
        return order_reference;
    }

    public void setOrderReference(Long order_reference) {
        this.order_reference = order_reference;
    }

    public Long getClientReference() {
        return client_reference;
    }

    public void setClientReference(Long client_reference) {
        this.client_reference = client_reference;
    }

    public Long getBillingAddress() {
        return billing_address;
    }

    public void setBillingAddress(Long billing_address) {
        this.billing_address = billing_address;
    }

    public Long getDeliveryAddress() {
        return delivery_address;
    }

    public void setDeliveryAddress(Long delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Long getWineReference() {
        return wine_reference;
    }

    public void setWineReference(Long wine_reference) {
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
