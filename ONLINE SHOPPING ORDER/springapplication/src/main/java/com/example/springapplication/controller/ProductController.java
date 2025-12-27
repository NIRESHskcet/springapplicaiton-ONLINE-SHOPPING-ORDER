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

import com.example.springapplication.model.Product;
import com.example.springapplication.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping
    public ResponseEntity<Product> addData(@RequestBody Product product){
        
        if(product==null){
            return ResponseEntity.badRequest().build();
        }
        return service.addData(product);

    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return service.getAllProduct();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateData(@PathVariable int id,@RequestBody Product update){
        return service.updateData(id,update);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteData(@PathVariable int id){
        return service.deleteData(id);
    }
}
