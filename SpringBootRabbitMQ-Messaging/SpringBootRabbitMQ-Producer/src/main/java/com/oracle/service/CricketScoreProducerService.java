package com.oracle.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oracle.dto.CricketScore;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CricketScoreProducerService {
	
	@Value("${rabbitmq.score.routing.key}")
	private String scoreMessageRoutingKey;

	@Value("${rabbitmq.exchange}")
	private String rabbitMQExchange;

	private RabbitTemplate rabbitTemplate;

	public CricketScoreProducerService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public String publishScore(CricketScore cricketScore) {
		rabbitTemplate.convertAndSend(rabbitMQExchange, scoreMessageRoutingKey, cricketScore);
		log.info("Score Published======> "+cricketScore);
		return "Score Published======> "+cricketScore;
	}

}
