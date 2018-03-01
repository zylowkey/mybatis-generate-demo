package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
//在实体类中定义的数据类型要用包装类型(Long,Integer),而不使用基本数据类型(long,int)。因为在Spring MVC中，使用基本数据类型会自动赋予初始值，不是为空
//@Entity指明这是一个和数据库表映射的实体类
@Entity
//JPA NamedQuery查询
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",query = "select p from Person p where p.name=?1 and address=?2")
public class Person {
	//@Id指明这个属性映射为数据库的主键
	@Id
	//@GeneratedValue默认使用主键生成方式为自增，hibernate会自动生成一个名为HIBERNATE_SEQUENCE的序列
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private Integer age;
	
	private String address;

	public Person() {
		super();
	}

	public Person(Long id, String name, Integer age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
