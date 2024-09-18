package com.oracle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.model.NotificationMessage;
import com.oracle.service.RedisMessagePublisherService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	
	private final RedisMessagePublisherService redisMessagePublisherService;
	
	public NotificationController(RedisMessagePublisherService redisMessagePublisherService) {
		this.redisMessagePublisherService = redisMessagePublisherService;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publishNotification(@RequestBody NotificationMessage notificationMessage) {
		redisMessagePublisherService.publish(notificationMessage);
		return ResponseEntity.ok("Notification Sent: "+notificationMessage);
	}

}
