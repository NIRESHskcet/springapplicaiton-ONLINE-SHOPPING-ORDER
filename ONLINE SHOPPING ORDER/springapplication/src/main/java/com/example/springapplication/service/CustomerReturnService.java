package com.example.springapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapplication.model.CustomerReturn;
import com.example.springapplication.repository.CustomerReturnRepo;

@Service
public class CustomerReturnService {
    @Autowired
    private CustomerReturnRepo repo;

    public ResponseEntity<CustomerReturn> createCustomerReturn(CustomerReturn cr){
        CustomerReturn customerReturn = repo.save(cr);
        if(customerReturn==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(customerReturn,HttpStatus.CREATED);
    }
    public ResponseEntity<List<CustomerReturn>> getAllCustomer(){
        return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<CustomerReturn> getCustomerById(int productId){
        CustomerReturn cusRe = repo.findById(productId).orElse(null);
        return new ResponseEntity<>(cusRe,HttpStatus.OK);
        
    }
}
