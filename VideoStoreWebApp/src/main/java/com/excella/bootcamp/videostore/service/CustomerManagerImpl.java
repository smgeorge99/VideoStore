/**
 * 
 */
package com.excella.bootcamp.videostore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excella.bootcamp.videostore.dao.CustomerDAO;
import com.excella.bootcamp.videostore.model.Customer;

/**
 * 
 * @author sean
 */
@Component
public class CustomerManagerImpl implements CustomerManager {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer createNewCustomer(Customer customer) {
		Integer newCustomerId = customerDAO.addNewCustomer(customer);
		customer.setCustomerId(newCustomerId);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public List<Customer> getRegularCustomers() {
		return customerDAO.getRegularCustomers();
	}

	@Override
	public List<Customer> getVipCustomers() {
		return customerDAO.getVipCustomers();
	}
	
}
