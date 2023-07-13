package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Customer;
import com.cdac.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/customer/add")
	public String add(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return "Customer added!";
	}
	
	@GetMapping("/customer/fetch/all")
	public List<Customer> fetchAll() {
		return customerRepository.findAll();
	}
}
