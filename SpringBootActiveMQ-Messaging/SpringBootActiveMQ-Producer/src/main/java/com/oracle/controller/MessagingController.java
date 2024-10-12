package com.oracle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.dto.Student;
import com.oracle.service.QueueProducer;
import com.oracle.service.TopicProducer;

@RestController
@RequestMapping("/publish/")
public class MessagingController {
	
	private final QueueProducer queueProducer;
	
	private final TopicProducer topicProducer;
	
	public MessagingController(QueueProducer queueProducer, TopicProducer topicProducer) {
		this.queueProducer = queueProducer;
		this.topicProducer = topicProducer;
	}
	
	@PostMapping("/queue-message")
	public ResponseEntity<String> sendQueueMessage(@RequestBody Student student) {
		String message = queueProducer.sendToQueue(student);
		return ResponseEntity.ok(message);
	}
	
	@PostMapping("/topic-message")
	public ResponseEntity<String> sendTopicMessage(@RequestBody Student student) {
		String message = topicProducer.sendToTopic(student);
		return ResponseEntity.ok(message);
	}

}
