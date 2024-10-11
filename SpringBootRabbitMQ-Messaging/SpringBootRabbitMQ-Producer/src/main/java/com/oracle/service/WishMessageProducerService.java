package com.oracle.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WishMessageProducerService {
	
	@Value("${rabbitmq.wish.routing.key}")
	private String wishMessageRoutingKey;
	
	@Value("${rabbitmq.exchange}")
	private String rabbitMQExchange;
	
	private RabbitTemplate rabbitTemplate;
	
	public WishMessageProducerService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public String sendMessage(String message) {
		rabbitTemplate.convertAndSend(rabbitMQExchange, wishMessageRoutingKey, message);
		log.info("Message Sent======> "+message);
		return "Message Sent======> "+message;
	}

}
