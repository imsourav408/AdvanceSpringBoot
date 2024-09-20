package com.oracle.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.oracle.constants.KafkaConstants;

@Configuration
public class KafkaConfig {

	public NewTopic topic() {
		return TopicBuilder.name(KafkaConstants.SCORE_BROADCAST_TOPIC.getValue()).build();
	}

}
