package com.oracle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.dto.CricketScore;
import com.oracle.service.CricketScoreProducerService;
import com.oracle.service.WishMessageProducerService;

@RestController
@RequestMapping("/publish/")
public class RabbitMQPublishApi {

	private WishMessageProducerService wishMessageProducerService;

	private CricketScoreProducerService cricketScoreProducerService;

	public RabbitMQPublishApi(WishMessageProducerService wishMessageProducerService,
			CricketScoreProducerService cricketScoreProducerService) {
		this.wishMessageProducerService = wishMessageProducerService;
		this.cricketScoreProducerService = cricketScoreProducerService;
	}

	@PostMapping("/wish-message")
	public ResponseEntity<String> publishWishMessage(@RequestBody String message) {
		String result = wishMessageProducerService.sendMessage(message);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/cricket-score")
	public ResponseEntity<String> publishCricketScore(@RequestBody CricketScore cricketScore) {
		String result = cricketScoreProducerService.publishScore(cricketScore);
		return ResponseEntity.ok(result);
	}

}
