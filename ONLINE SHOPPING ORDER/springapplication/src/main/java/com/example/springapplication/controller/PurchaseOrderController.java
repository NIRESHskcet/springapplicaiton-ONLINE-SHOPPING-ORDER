package com.example.springapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapplication.model.PurchaseOrder;
import com.example.springapplication.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderService service;

    @PostMapping
    public ResponseEntity<PurchaseOrder> createProductOrder(@RequestBody PurchaseOrder order){
        return service.createProductOrder(order);
    }
    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllOrder(){
        return service.getAllOrder();
    }
    @GetMapping("/{purchaseOrderId}")
    public ResponseEntity<PurchaseOrder> getOrderById(@PathVariable int purchaseOrderId){
        return service.getOrderById(purchaseOrderId);
    }
    @PutMapping("/{purchaseOrderId}")
    public ResponseEntity<PurchaseOrder> updateOrder(@PathVariable int purchaseOrderId,@RequestBody PurchaseOrder update){
        return service.updateOrder(purchaseOrderId,update);
    }
}
