package com.se.example.springbootkotlinh2sample.service

import org.springframework.stereotype.Service
import com.se.example.springbootkotlinh2sample.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import com.se.example.springbootkotlinh2sample.entities.Customer
import java.util.function.Consumer
import javax.transaction.Transactional


@Service
class CustomerServices {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    fun deleteAll() {
        customerRepository.deleteAll()
    }

    fun save(customer: Customer) {
        customerRepository.save(customer)
        customerRepository.flush()
    }

    @Transactional
    fun showAll() {
        val custs = customerRepository.findAll()
        custs.forEach(Consumer<Customer> { println(it) })
    }


}