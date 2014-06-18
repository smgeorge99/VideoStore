package com.excella.bootcamp.videostore.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.excella.bootcamp.videostore.model.Customer;
import com.excella.bootcamp.videostore.model.RegularCustomer;
import com.excella.bootcamp.videostore.model.VIPCustomer;

public class NewCustomerFormTest {

	@Test
	public void testIsVIPCustomer() {
		NewCustomerForm vip = new NewCustomerForm();
		vip.setMembershipType("VIP");
		
		assertTrue(vip.isVipCustomer());
	}
	
	@Test
	public void testIsNotVIPCustomer() {
		NewCustomerForm reg = new NewCustomerForm();
		reg.setMembershipType("Reg");
		
		assertFalse(reg.isVipCustomer());
	}
	
	@Test
	public void testCreateVIPCustomer() {
		NewCustomerForm vip = new NewCustomerForm();
		vip.setFirstName("Sean");
		vip.setLastName("Combs");
		vip.setMembershipType("VIP");
		
		Customer customer = vip.createCustomerObject();
		assertTrue(customer instanceof VIPCustomer);
		assertEquals("Sean Combs", customer.getName());
	}

	@Test
	public void testCreateRegularCustomer() {
		NewCustomerForm reg = new NewCustomerForm();
		reg.setFirstName("Sean");
		reg.setLastName("Combs");
		reg.setMembershipType("Reg");
		
		Customer customer = reg.createCustomerObject();
		assertTrue(customer instanceof RegularCustomer);
		assertEquals("Sean Combs", customer.getName());
	}

}
