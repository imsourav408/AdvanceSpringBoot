package com.oracle.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.oracle.constants.KafkaConstants;
import com.oracle.model.Score;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducerService {

	private final KafkaTemplate<String, Score> kafkaTemplate;

	public KafkaProducerService(KafkaTemplate<String, Score> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public String publishScore(Score score) {
		kafkaTemplate.send(KafkaConstants.SCORE_BROADCAST_TOPIC.getValue(), score);
		log.info("Cricket Score Published: " + score);
		return "Cricket Score Published: " + score;
	}

}
