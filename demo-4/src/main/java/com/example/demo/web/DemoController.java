package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Person;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person) {
		return demoService.savePersonWithRollBack(person);
	}
	
	@RequestMapping("/norollback")
	public Person norollback(Person person) {
		return demoService.savePersonWithoutRollBack(person);
	}
	
}
