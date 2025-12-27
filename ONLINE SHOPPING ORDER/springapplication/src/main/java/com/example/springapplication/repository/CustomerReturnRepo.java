package com.example.springapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapplication.model.CustomerReturn;

@Repository
public interface CustomerReturnRepo extends JpaRepository<CustomerReturn,Integer> {

}
