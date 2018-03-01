package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonRepository2;
import com.example.demo.domain.Person;


@RestController
public class DataController2 {
	@Autowired
	PersonRepository2 personRepository;
	
	@RequestMapping("/auto")
	public Page<Person> auto(Person person){
		Page<Person> page = personRepository.findByAuto(person, new PageRequest(0, 10));
		return page;
	}
}
