package com.example.springapplication.model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchaseOrderId;
    @Column(nullable=false,unique=true)
    private String orderNumber;
    // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderDate;
    private String status;
    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplier;



    public PurchaseOrder() {
    }



    public PurchaseOrder(String orderNumber,LocalDateTime orderDate, String status, Supplier supplier) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.supplier = supplier;
    }



    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }



    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }



    public String getOrderNumber() {
        return orderNumber;
    }



    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }



    public LocalDateTime getOrderDate() {
        return orderDate;
    }



    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }



    public Supplier getSupplier() {
        return supplier;
    }



    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    


    



    
}
