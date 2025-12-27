package com.example.springapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapplication.model.PurchaseOrder;
import com.example.springapplication.repository.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {
    @Autowired
    private PurchaseOrderRepo repo;

    public ResponseEntity<PurchaseOrder> createProductOrder(PurchaseOrder order){
        PurchaseOrder newOrder = repo.save(order);
        if(newOrder == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
    }
    public ResponseEntity<List<PurchaseOrder>> getAllOrder(){
        List<PurchaseOrder> allOrder = repo.findAll();
        if(allOrder == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(allOrder,HttpStatus.OK);
    }
    public ResponseEntity<PurchaseOrder> getOrderById(int orderNo){
        PurchaseOrder n = repo.findById(orderNo).orElse(null);
        if(n == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(n,HttpStatus.OK);
    }
    public ResponseEntity<PurchaseOrder> updateOrder(int id,PurchaseOrder update){
        PurchaseOrder existing = repo.findById(id).orElse(null);
        if(existing==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        existing.setOrderNumber(update.getOrderNumber());
        existing.setOrderDate(update.getOrderDate());
        existing.setStatus(update.getStatus());
        PurchaseOrder newPur = repo.save(existing);
        return new ResponseEntity<>(newPur,HttpStatus.OK);
    }
}
