package com.excella.bootcamp.videostore.controller;

import com.excella.bootcamp.videostore.model.Customer;
import com.excella.bootcamp.videostore.model.RegularCustomer;
import com.excella.bootcamp.videostore.model.VIPCustomer;

public class NewCustomerForm {

	private static final String VIP_MEMBERSHIP_TYPE = "VIP";
	
	private String firstName;
	private String lastName;
	private String membershipType;
	
	public final String getFirstName() {
		return firstName;
	}
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public final String getLastName() {
		return lastName;
	}
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public final String getMembershipType() {
		return membershipType;
	}
	public final void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public Customer createCustomerObject() {
		Customer customer = null;
		String name = getFirstName() + " " + getLastName();
		if(isVipCustomer()) {
			customer = new VIPCustomer(name);
		} else {
			customer = new RegularCustomer(name);
		}
		return customer;
	}
	
	public boolean isVipCustomer() {
		return VIP_MEMBERSHIP_TYPE.equals(getMembershipType());
	}
}
