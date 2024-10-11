package com.oracle.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WishMessageListener {
	
	@RabbitListener(queues = {"${rabbitmq.wish.queue.name}"})
	public void consume(String message) {
		log.info("Message Received===>"+ message);
	}
}
