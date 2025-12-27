package com.example.springapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapplication.model.PurchaseOrderItem;
import com.example.springapplication.repository.PurchaseOrderItemRepo;

@Service
public class PurchaseOrderItemService {
    @Autowired
    private PurchaseOrderItemRepo repo;

    public ResponseEntity<PurchaseOrderItem> createItem(PurchaseOrderItem item){
        PurchaseOrderItem i = repo.save(item);
        return new ResponseEntity<>(i,HttpStatus.CREATED);
    }
    public ResponseEntity<List<PurchaseOrderItem>> getAllItems(){
        List<PurchaseOrderItem> it = repo.findAll();
        return new ResponseEntity<>(it,HttpStatus.OK);
    }
}
