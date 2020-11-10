package com.javasampleapproach.jdbcpostgresql.dao;

import java.util.List;
import com.javasampleapproach.jdbcpostgresql.model.Customer;

public interface CustomerDao {
	void insert(Customer cus);
	void inserBatch(List<Customer> customers);
	List<Customer> loadAllCustomer();
	Customer findCustomerById(long cust_id);
	String findNameById(long cust_id);
	int getTotalNumberCustomer();
}
