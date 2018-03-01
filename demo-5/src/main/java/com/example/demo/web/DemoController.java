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
	
	@RequestMapping("/put")
	public Person put(Person person) {
		return demoService.savePerson(person);
	}
	
	@RequestMapping("/able")
	public Person cacheable(Person person) {
		return demoService.findOne(person);
	}
	
	@RequestMapping("/evit")
	public String evit(Long id) {
		demoService.remove(id);
		return "ok";
	}
}
