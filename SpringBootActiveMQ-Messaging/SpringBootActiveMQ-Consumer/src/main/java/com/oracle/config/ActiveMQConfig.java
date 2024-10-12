package com.oracle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
public class ActiveMQConfig {

	@Bean
	JmsListenerContainerFactory<?> jmsListenerContainerTopic(DefaultJmsListenerContainerFactory connectionFactory) {
		connectionFactory.setPubSubDomain(true);
		return connectionFactory;
	}
}
