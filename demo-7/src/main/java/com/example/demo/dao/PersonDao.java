package com.example.demo.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Person;

@Repository
public class PersonDao {
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Resource(name="stringRedisTemplate")
	//使用@Resource注解指定stringRedisTemplate，可注入基于字符串的简单属性操作方法
	ValueOperations<String,String> valOpsStr;
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	
	@Resource(name="redisTemplate")
	//使用@Resource注解指定redisTemplate，可注入基于对象的简单属性操作方法
	ValueOperations<Object, Object> valOps;
	
	
	public void stringRedisTemplateDemo() {
		valOpsStr.set("xx", "yy");
	}
	
	public void save(Person person) {
		valOps.set(person.getId(), person);
	}
	
	public String getString() {
		return valOpsStr.get("xx");
	}
	
	public Person getPerson() {
		return (Person) valOps.get("1");
	}
}
