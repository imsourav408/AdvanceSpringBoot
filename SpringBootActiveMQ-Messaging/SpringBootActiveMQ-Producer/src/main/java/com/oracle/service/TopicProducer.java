package com.oracle.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.oracle.dto.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TopicProducer {

	private final JmsTemplate jmsTemplate;

	@Value("${activemq.topic.name}")
	private String topicName;

	public TopicProducer(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
		jmsTemplate.setPubSubDomain(true);
	}

	public String sendToTopic(Student student) {
		jmsTemplate.convertAndSend(topicName, student);
		log.info("Message sent to topic: " + student);
		return "Message sent to topic: " + student;
	}

}
