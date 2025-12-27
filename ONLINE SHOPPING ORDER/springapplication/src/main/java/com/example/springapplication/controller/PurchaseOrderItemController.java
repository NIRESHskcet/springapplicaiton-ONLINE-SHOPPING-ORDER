package com.example.springapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapplication.model.PurchaseOrderItem;
import com.example.springapplication.service.PurchaseOrderItemService;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {
    @Autowired
    private PurchaseOrderItemService service;
    @PostMapping
    public ResponseEntity<PurchaseOrderItem> createItem(@RequestBody PurchaseOrderItem item){
        return service.createItem(item);
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PurchaseOrderItem>> getAllItems(){
        return service.getAllItems();
    }
}
