package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Person;
@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Transactional(rollbackFor= {IllegalArgumentException.class})
	@Override
	public Person savePersonWithRollBack(Person person) {
		Person p = personRepository.save(person);
		if(person.getName().equals("汪云飞")) {
			throw new IllegalArgumentException("汪云飞已存在，数据将回滚");
		}
		return p;
	}
	
	@Transactional(noRollbackFor= {IllegalArgumentException.class})
	@Override
	public Person savePersonWithoutRollBack(Person person) {
		Person p = personRepository.save(person);
		if(person.getName().equals("汪云飞")) {
			throw new IllegalArgumentException("汪云飞已存在，数据将回滚");
		}
		return p;
	}

}
