package com.example.springapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchaseOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private int quantity;
    private double unitPrice;
    @ManyToOne
    @JoinColumn(name="purchaseOrderId")
    private PurchaseOrder purchaseOrder;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;


    public PurchaseOrderItem() {
    }


    public PurchaseOrderItem(int quantity, double unitPrice, PurchaseOrder purchaseOrder, Product product) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.purchaseOrder = purchaseOrder;
        this.product = product;
    }


    public int getItemId() {
        return itemId;
    }


    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getUnitPrice() {
        return unitPrice;
    }


    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }


    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }


    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }


    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
