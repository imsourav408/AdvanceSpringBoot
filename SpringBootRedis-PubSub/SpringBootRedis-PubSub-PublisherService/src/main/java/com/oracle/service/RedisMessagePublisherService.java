package com.oracle.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.oracle.model.NotificationMessage;

@Service
public class RedisMessagePublisherService {

	private final RedisTemplate<String, Object> redisTemplate;

	private final ChannelTopic channelTopic;

	public RedisMessagePublisherService(RedisTemplate<String, Object> redisTemplate, ChannelTopic channelTopic) {
		this.redisTemplate = redisTemplate;
		this.channelTopic = channelTopic;
	}

	public void publish(NotificationMessage notificationMessage) {
		redisTemplate.convertAndSend(channelTopic.getTopic(), notificationMessage);
	}

}
