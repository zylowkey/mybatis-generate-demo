package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(max=4,min=2)//使用JSP-303注解来校验数据
	private String name;
	
	private int age;
	
	private String nation;
	
	private String address;

	public Person() {
		super();
	}

	public Person(Long id, String name, int age, String nation, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.nation = nation;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
