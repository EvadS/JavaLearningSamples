package com.se.example.springbootkotlinh2sample.repositories

import com.se.example.springbootkotlinh2sample.entities.Customer
import com.se.example.springbootkotlinh2sample.entities.CustomerId
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, CustomerId> {
}