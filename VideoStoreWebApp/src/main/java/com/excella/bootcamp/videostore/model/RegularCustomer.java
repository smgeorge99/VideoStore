package com.excella.bootcamp.videostore.model;

public class RegularCustomer extends Customer {

	private static final String DISCOUNT_RATE = "0.00";
	
	public RegularCustomer(String name) {
		super(name, DISCOUNT_RATE);
	}


}
