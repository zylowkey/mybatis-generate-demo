package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class Demo10Application implements CommandLineRunner{
	@Autowired
	JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo10Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		jmsTemplate.send("my-destation",new Msg());
	}
}
