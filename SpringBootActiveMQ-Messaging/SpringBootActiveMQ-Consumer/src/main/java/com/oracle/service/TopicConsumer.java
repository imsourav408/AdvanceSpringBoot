package com.oracle.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.oracle.dto.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TopicConsumer {
	
	@JmsListener(destination = "${activemq.topic.name}")
	public void receiveFromTopic(Student student) {
		log.info("Message received from topic: " + student);
	}

}
