package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Person;

@RestController
public class DataController {
	//Spring Data JPA 已经自动注册bean，所以可以自动注入
	@Autowired
	PersonRepository personRepository;
	@RequestMapping("/save")
	public Person save(String name,String address,Integer age) {
		Person p = personRepository.save(new Person(null, name, age, address));
		
		return p;
	}
	
	@RequestMapping("/q1")
	public List<Person> q1(String address){
		List<Person> persons = personRepository.findByAddress(address);
		
		return persons;
	}
	
	
	@RequestMapping("/q2")
	public Person q2(String name,String address) {
		Person p = personRepository.findByNameAndAddress(name, address);
		
		return p;
	}
	
	@RequestMapping("/q3")
	public Person q3(String name,String address) {
		Person p = personRepository.withNameAndAddressQuery(name, address);
		
		return p;
	}
	
	@RequestMapping("/q4")
	public List<Person> q4(String name,String address) {
		List<Person> p = personRepository.withNameAndAddressNamedQuery(name, address);		
		
		return p;
	}
	
	@RequestMapping("/sort")
	public List<Person> sort(){
		List<Person> p = personRepository.findAll(new Sort(Direction.ASC,"age"));
		return p;
	}
	
	
	@RequestMapping("/page")
	public Page<Person> page(){
		Page<Person> p = personRepository.findAll(new PageRequest(1,2));
		
		return p;
	}
}
