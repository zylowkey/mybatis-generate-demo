package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.domain.Person;

public interface PersonRepository extends MongoRepository<Person, String>{
	Person findByName(String name);
	@Query("{'age':?0}")//查询参数构造JSON字符串即可
	List<Person> withQueryFindByAge(Integer age);
}
