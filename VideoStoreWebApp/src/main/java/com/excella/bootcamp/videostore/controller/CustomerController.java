/**
 * 
 */
package com.excella.bootcamp.videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excella.bootcamp.videostore.model.Customer;
import com.excella.bootcamp.videostore.service.CustomerManager;

/**
 * 
 * @author sean
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerManager customerManager;
	
	@RequestMapping("/viewAllCustomers")
    public String viewAllCustomers(Model model) {
		model.addAttribute("customers", customerManager.getAllCustomers());
        return "customersList";
    }
	
	@RequestMapping("/viewVipCustomers")
    public String viewVipCustomers(Model model) {
		model.addAttribute("customers", customerManager.getVipCustomers());
        return "customersList";
    }
	
	@RequestMapping("/viewRegularCustomers")
    public String viewRegularCustomers(Model model) {
		model.addAttribute("customers", customerManager.getRegularCustomers());
        return "customersList";
    }
	
	@RequestMapping("/addCustomer")
    public String goToCustomerCreatePage(Model model) {
		model.addAttribute("newCustomer", new NewCustomerForm());
        return "addCustomer";
    }
	
	@RequestMapping("/createCustomer")
    public String goToCustomerCreatePage(NewCustomerForm newCustomer, Model model) {
		Customer customer = customerManager.createNewCustomer(newCustomer.createCustomerObject());
		model.addAttribute("customer", customer);
		model.addAttribute("memberType", newCustomer.getMembershipType());
        return "customerDetail";
    }
}
