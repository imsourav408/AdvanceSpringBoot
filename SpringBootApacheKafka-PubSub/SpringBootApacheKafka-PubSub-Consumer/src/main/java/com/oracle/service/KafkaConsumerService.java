package com.oracle.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.oracle.constants.KafkaConstants;
import com.oracle.model.Score;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumerService {

	@KafkaListener(topics = KafkaConstants.SCORE_BROADCAST_TOPIC, groupId = KafkaConstants.GROUP_ID)
	public void consumePublishedScore(Score score) {
		log.info("Score updated: " + score);
	}

}
