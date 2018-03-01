package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	@RabbitListener(queues = "my-queue")
	//使用@RabbitListener来监听RabbitMQ的目的地发送的消息，通过queues属性指定要监听的目的地
	public void receiveMessage(String message) throws Exception {
		Thread.sleep(15000);
		System.out.println("Received <"+message+">");
	}
}
