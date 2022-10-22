package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;

	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{theId}")
	public Customer getCustomers(@PathVariable int theId) {
		Customer customer =customerService.getCustomer(theId);
		if (customer==null) {
			throw new CustomerNotFoundException("Customer with id = "+theId+" not found");
		}
		
		return customer;
	}
	
	@DeleteMapping("/customers/{theId}")
	public List<Customer> deleteCustomers(@PathVariable int theId) {
		Customer customer =customerService.getCustomer(theId);
		if (customer==null) {
			throw new CustomerNotFoundException("Customer with id = "+theId+" not found");
		}
		customerService.deleteCustomer(theId);
		
		return customerService.getCustomers();
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
	
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer){
		
		customerService.saveCustomer(theCustomer);
	
		
		return theCustomer;
	}
	
}
