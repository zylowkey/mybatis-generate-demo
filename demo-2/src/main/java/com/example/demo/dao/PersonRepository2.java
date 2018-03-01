package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Person;
import com.example.demo.support.CustomRepository;

//继承CustomRepository，使用在自定义Repository中实现的功能
public interface PersonRepository2 extends CustomRepository<Person, Long>{
	
	List<Person> findByAddress(String address);
	
	Person findByNameAndAddress(String name,String address);
	
	@Query("select p from Person p where p.name= :name and p.address= :address")
	Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);
	
	//使用NamedQuery查询，注意在实体类中做的@NamedQuery的定义
	List<Person> withNameAndAddressNamedQuery(String name,String address);
}
