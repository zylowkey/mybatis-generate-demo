package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Customer;
import com.example.demo.repositories.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/findByLastName/{name}")
	public void findByLastName(@PathVariable String name) {
		List<Customer> result = customerRepository.findByLastName(name);
		if(!result.isEmpty()) {
			for (Customer customer : result) {
				System.out.println(customer.toString());
			}
		}
	}
}
