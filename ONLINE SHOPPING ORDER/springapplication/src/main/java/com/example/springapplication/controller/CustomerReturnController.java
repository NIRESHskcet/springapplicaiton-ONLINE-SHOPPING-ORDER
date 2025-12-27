package com.example.springapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapplication.model.CustomerReturn;
import com.example.springapplication.service.CustomerReturnService;

@RestController
@RequestMapping("/api/customer-returns")
public class CustomerReturnController {
    @Autowired
    private CustomerReturnService service;
    @PostMapping
    public ResponseEntity<CustomerReturn> createCustomerReturn(@RequestBody CustomerReturn cr){
        return service.createCustomerReturn(cr);
    }
    @GetMapping
    public ResponseEntity<List<CustomerReturn>> getAllCustomer(){
        return service.getAllCustomer();
    }
    @GetMapping("/{productId}")
    public ResponseEntity<CustomerReturn> getCustomerById(@PathVariable int productId){
        return service.getCustomerById(productId);
    }
}
