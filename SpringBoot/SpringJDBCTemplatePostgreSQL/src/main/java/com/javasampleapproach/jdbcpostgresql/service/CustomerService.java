package com.javasampleapproach.jdbcpostgresql.service;

import java.util.List;

import com.javasampleapproach.jdbcpostgresql.model.Customer;

public interface CustomerService {
	void insert(Customer cus);
	void insertBatch(List<Customer> customers);
	void loadAllCustomer();
	void getCustomerById(long cust_id);
	void getCustomerNameById(long cust_id);
	void getTotalNumerCustomer();
}
