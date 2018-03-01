package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.domain.Person;

@RepositoryRestResource(path="people")//Spring Data REST的默认规则就是在实体类之后加"s"来形成路径 http://localhost:8089/api/persons
//使用@RepositoryRestResource可定制节点路径http://localhost:8089/api/people
public interface PersonRepository extends JpaRepository<Person,Long>{
	//直接将方法暴露为REST资源
	//@RestResource(path="NameStartsWith" ,rel="NameStartsWith")
	Person findByNameStartsWith(String name);
}
