package com.oracle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.model.Score;
import com.oracle.service.KafkaProducerService;

@RestController
@RequestMapping("/publish")
public class ScoreBroadcastController {

	private final KafkaProducerService kafkaProducerService;

	public ScoreBroadcastController(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	@PostMapping("/score")
	public ResponseEntity<String> publishScore(@RequestBody Score score) {
		return ResponseEntity.ok(kafkaProducerService.publishScore(score));
	}

}
