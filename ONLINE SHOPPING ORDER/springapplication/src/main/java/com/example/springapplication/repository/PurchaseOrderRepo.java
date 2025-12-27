package com.example.springapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapplication.model.PurchaseOrder;

@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder,Integer> {

}
