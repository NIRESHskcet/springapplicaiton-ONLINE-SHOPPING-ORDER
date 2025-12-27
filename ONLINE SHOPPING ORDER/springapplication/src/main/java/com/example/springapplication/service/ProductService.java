package com.example.springapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapplication.exception.ResourceNotFoundException;
import com.example.springapplication.model.Product;
import com.example.springapplication.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public ResponseEntity<Product> addData(Product product){
        try{    
            Product newProduct = repo.save(product);
            return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> newProduct = repo.findAll();
        if(newProduct.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newProduct,HttpStatus.OK);
        
    }
    public ResponseEntity<Product> getProductById(int id){
        Product product = repo.findById(id).
                        orElseThrow(()-> new ResourceNotFoundException("Product Not Found with id "+ id));
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    public ResponseEntity<Product> updateData(int id,Product update){
        Product existing = repo.findById(id).orElse(null);
        if(existing==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existing.setProductName(update.getProductName());
        existing.setDescription(update.getDescription());
        existing.setPrice(update.getPrice());
        existing.setStockQuantity(update.getStockQuantity());
        Product p = repo.save(existing);
        return new ResponseEntity<>(p,HttpStatus.OK);
        
    }
    public ResponseEntity<Product> deleteData(int id){
        Product n = repo.findById(id).orElse(null);
        repo.deleteById(id);
        return new ResponseEntity<>(n,HttpStatus.OK);
    }
    
}
