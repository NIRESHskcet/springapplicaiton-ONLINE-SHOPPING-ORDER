package com.example.springapplication.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomerReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerReturnId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime returnDate;
    private int quantity;
    private String reason;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
    public CustomerReturn() {
    }
    public CustomerReturn( LocalDateTime returnDate, int quantity, String reason,
            Product product) {
        this.returnDate = returnDate;
        this.quantity = quantity;
        this.reason = reason;
        this.product = product;
    }
    public int getCustomerReturnId() {
        return customerReturnId;
    }
    public void setCustomerReturnId(int customerReturnId) {
        this.customerReturnId = customerReturnId;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    

    
    
}
