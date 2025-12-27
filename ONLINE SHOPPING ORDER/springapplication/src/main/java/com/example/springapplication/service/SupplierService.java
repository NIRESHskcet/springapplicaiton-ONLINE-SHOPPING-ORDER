package com.example.springapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapplication.exception.ResourceNotFoundException;
import com.example.springapplication.model.Supplier;
import com.example.springapplication.repository.SupplierRepo;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepo repo;

    public ResponseEntity<Supplier> addData(Supplier supplier){
        Supplier sup = repo.save(supplier);
        try{
            return new ResponseEntity<>(sup,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<Supplier>> getAllSupplier(){
        List<Supplier> newSup = repo.findAll();
        if(newSup == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newSup,HttpStatus.OK);
    }
    public ResponseEntity<Supplier> getSupplierById(int id){
        Supplier nsup = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier Not Found with id "+id));
        return new ResponseEntity<>(nsup,HttpStatus.OK);
    }
    public ResponseEntity<Supplier> updateData(int id,Supplier update){
        Supplier existing = repo.findById(id).orElse(null);
        if(existing==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        existing.setSupplierName(update.getSupplierName());
        existing.setContactNumber(update.getContactNumber());
        existing.setEmail(update.getEmail());
        existing.setAddress(update.getAddress());
        Supplier newSup = repo.save(existing);
        return new ResponseEntity<>(newSup,HttpStatus.OK);
    }
    public ResponseEntity<String> deleteData(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return new ResponseEntity<>("records deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("can't find record",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
