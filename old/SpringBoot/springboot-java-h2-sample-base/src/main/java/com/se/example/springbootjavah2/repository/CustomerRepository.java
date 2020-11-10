package com.se.example.springbootjavah2.repository;

import com.se.example.springbootjavah2.entities.Customer;
import com.se.example.springbootjavah2.entities.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
}