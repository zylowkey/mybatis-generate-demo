package com.example.demo.service;

import com.example.demo.domain.Person;

public interface DemoService {
	public Person savePersonWithRollBack(Person person);
	
	public Person savePersonWithoutRollBack(Person person);
	
	
}
