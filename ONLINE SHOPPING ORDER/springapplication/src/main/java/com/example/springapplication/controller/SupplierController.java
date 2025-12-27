package com.example.springapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapplication.model.Supplier;
import com.example.springapplication.service.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    public SupplierService service;

    @PostMapping
    public ResponseEntity<Supplier> addData(@RequestBody Supplier supplier){
        return service.addData(supplier);
    }
    @GetMapping
    public ResponseEntity<List<Supplier>> get(){
        return service.getAllSupplier();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int id){
        return service.getSupplierById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateData(@PathVariable int id,@RequestBody Supplier supplier){
        return service.updateData(id,supplier);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable int id){
        return service.deleteData(id);
    }

}
