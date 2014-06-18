/**
 * 
 */
package com.excella.bootcamp.videostore.service;

import java.util.List;

import com.excella.bootcamp.videostore.model.Customer;

/**
 * @author sean
 *
 */
public interface CustomerManager {

	Customer createNewCustomer(Customer customer);
	
	List<Customer> getAllCustomers();

	List<Customer> getRegularCustomers();

	List<Customer> getVipCustomers();
}
