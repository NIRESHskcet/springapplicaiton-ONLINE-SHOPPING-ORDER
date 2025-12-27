package com.example.springapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapplication.model.PurchaseOrderItem;

@Repository
public interface PurchaseOrderItemRepo extends JpaRepository<PurchaseOrderItem,Integer>{
    
}
