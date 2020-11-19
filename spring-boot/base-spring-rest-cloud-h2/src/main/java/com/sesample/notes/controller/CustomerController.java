package com.sesample.notes.controller;

import com.sesample.notes.entities.Customer;
import com.sesample.notes.entities.Note;
import com.sesample.notes.mapper.CustomerMapper;
import com.sesample.notes.mapper.NoteMapper;
import com.sesample.notes.model.CustomerRequest;
import com.sesample.notes.model.CustomerResponse;
import com.sesample.notes.model.NoteResponse;
import com.sesample.notes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author Evgeniy Skiba on 18.11.2020
 * @project base-java-h2
 */

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> options() {
        //@formatter:off
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST,
                        HttpMethod.HEAD, HttpMethod.OPTIONS,
                        HttpMethod.PUT, HttpMethod.DELETE)
                .build();
        //@formatter:on
    }

    @GetMapping
    ResponseEntity<Collection<Customer>> getCollection() {
        return ResponseEntity.ok(this.customerRepository.findAll());
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {

        Customer customer = CustomerMapper.INSTANCE.customerRequestToCustomer(customerRequest);
        customerRepository.save(customer);

        CustomerResponse customerResponse = CustomerMapper.INSTANCE.customerToCustomerResponse(customer);
        return  ResponseEntity.ok(customerResponse);

    }
}
