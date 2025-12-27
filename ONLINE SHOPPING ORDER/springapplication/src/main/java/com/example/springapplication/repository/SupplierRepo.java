package com.example.springapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapplication.model.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Integer> {

}
