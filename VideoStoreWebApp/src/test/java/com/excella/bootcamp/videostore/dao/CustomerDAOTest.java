/**
 * 
 */
package com.excella.bootcamp.videostore.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.excella.bootcamp.videostore.model.Customer;
import com.excella.bootcamp.videostore.model.VIPCustomer;

/**
 * @author sean
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/data-context.xml")
public class CustomerDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Test
	public void testDAOInjectedProperly() {
		assertNotNull(customerDAO);
	}
	
	@Test
	public void testAddNewCustomer() {
		VIPCustomer customer = new VIPCustomer("Billy Bob");
		Integer id = customerDAO.addNewCustomer(customer);
		assertTrue(id.intValue() > 0);
	}
	
	@Test
	public void testGetAllCustomers() {
		List<Customer> customers = customerDAO.getAllCustomers();
		assertTrue(CollectionUtils.isNotEmpty(customers));
	}

}
