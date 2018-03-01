package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Person;
@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	@CachePut(value = "people" ,key = "#person.id")
	//@CachePut缓存新增的或更新的数据到缓存，其中缓存名称为people，数据的key是person的id
	public Person savePerson(Person person) {
		Person p = personRepository.save(person);
		System.out.println("为id、key为: "+p.getId()+"数据做了缓存");
		return p;
	}

	@Override
	@CacheEvict(value = "people")
	//@CacheEvict从缓存people中删除key为id的数据
	public void remove(Long id) {
		System.out.println("删除了id、key为 "+id+"的数据缓存");
		personRepository.delete(id);
	}

	@Override
	@Cacheable(value = "people",key = "#person.id")
	//@Cacheable缓存key为person的id数据到缓存people中。如果不指定key，则方法参数作为key保存到缓存中
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println("为id、key为: "+p.getId()+"数据做了缓存");
		return p;
	}
	

}
