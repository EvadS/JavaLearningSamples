package com.javasampleapproach.h2database.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.h2database.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
} 