package com.oracle.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.oracle.dto.CricketScore;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CricketScoreListener {

	@RabbitListener(queues = { "${rabbitmq.score.queue.name}" })
	public void consume(CricketScore cricketScore) {
		log.info("Cricket Score Received===>" + cricketScore);
	}

}
