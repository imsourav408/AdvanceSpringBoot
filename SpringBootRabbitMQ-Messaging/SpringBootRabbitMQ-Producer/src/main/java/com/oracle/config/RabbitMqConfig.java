package com.oracle.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Value("${rabbitmq.wish.queue.name}")
	private String wishMessageQueueName;

	@Value("${rabbitmq.score.queue.name}")
	private String scoreQueueName;

	@Value("${rabbitmq.wish.routing.key}")
	private String wishRoutingKey;

	@Value("${rabbitmq.score.routing.key}")
	private String scoreRoutingKey;

	@Value("${rabbitmq.exchange}")
	private String rabbitMQExchange;

	@Bean
	Queue wishMessageQueue() {
		return new Queue(wishMessageQueueName);
	}

	@Bean
	Queue scoreQueue() {
		return new Queue(scoreQueueName);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(rabbitMQExchange);
	}

	@Bean
	Binding wishMessageBinding() {
		return BindingBuilder.bind(wishMessageQueue()).to(exchange()).with(wishRoutingKey);
	}

	@Bean
	Binding scoreBinding() {
		return BindingBuilder.bind(scoreQueue()).to(exchange()).with(scoreRoutingKey);
	}

	@Bean
	MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}

}
