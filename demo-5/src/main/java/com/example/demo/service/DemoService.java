package com.example.demo.service;

import com.example.demo.domain.Person;

public interface DemoService {
	public Person savePerson(Person person);
	
	public void remove(Long id);
	
	public Person findOne(Person person);
	
	
}
