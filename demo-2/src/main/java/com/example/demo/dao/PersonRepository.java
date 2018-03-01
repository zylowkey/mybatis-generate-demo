package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{
	
	List<Person> findByAddress(String address);
	
	Person findByNameAndAddress(String name,String address);
	
	//使用命名参数Spring Data JPA支持用@Query注解在接口的方法上实现查询
	@Query("select p from Person p where p.name= :name and p.address= :address")
	//使用参数索引 @Query("select p from Person p where p.name=?1 and p.address=?2")
	Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);
	
	//使用NamedQuery查询，注意在实体类中做的@NamedQuery的定义
	List<Person> withNameAndAddressNamedQuery(String name,String address);
	
	//更新查询 Spring Data JPA支持@Modifying和@Query注解组合来事件更新查询，int返回受影响的行数
	@Modifying
	@Transactional
	@Query("update Person p set p.name=?1")
	int setName(String name);
}
