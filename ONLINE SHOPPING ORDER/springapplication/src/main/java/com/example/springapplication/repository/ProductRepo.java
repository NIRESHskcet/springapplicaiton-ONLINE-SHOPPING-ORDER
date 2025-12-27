package com.example.springapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapplication.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

}
