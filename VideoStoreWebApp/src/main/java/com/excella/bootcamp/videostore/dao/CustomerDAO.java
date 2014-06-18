package com.excella.bootcamp.videostore.dao;

import java.util.List;

import com.excella.bootcamp.videostore.model.Customer;

public interface CustomerDAO {

	Integer addNewCustomer(Customer customer);
	
	List<Customer> getAllCustomers();

	List<Customer> getRegularCustomers();

	List<Customer> getVipCustomers();

}