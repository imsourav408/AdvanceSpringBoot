package com.oracle.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.oracle.dto.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QueueProducer {

	private final JmsTemplate jmsTemplate;
	
	@Value("${activemq.queue.name}")
	private String queueName;

	public QueueProducer(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public String sendToQueue(Student student) {
		jmsTemplate.convertAndSend(queueName, student);
		log.info("Message sent to queue: "+student);
		return "Message sent to queue: "+student;
	}

}
