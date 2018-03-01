package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonDao;
import com.example.demo.domain.Person;

@RestController
public class DataController {
	@Autowired
	PersonDao personDao;
	
	@RequestMapping("/set")
	public void set() {
		Person person = new Person("1", "wyf", 32);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}
	
	
	@RequestMapping("/getStr")
	public String getStr() {
		return personDao.getString();
	}
	
	@RequestMapping("/getPerson")
	public Person getPerson() {
		return personDao.getPerson();
	}
}
