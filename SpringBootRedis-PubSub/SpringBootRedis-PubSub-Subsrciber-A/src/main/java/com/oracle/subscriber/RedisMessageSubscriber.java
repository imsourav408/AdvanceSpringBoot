package com.oracle.subscriber;

import java.io.IOException;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.model.NotificationMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisMessageSubscriber implements MessageListener {
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void onMessage(Message message, byte[] pattern) {
		try {
			NotificationMessage notificationMessage = objectMapper.readValue(message.getBody(), NotificationMessage.class);
			log.info("Subscriber A Received Message: " + notificationMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
