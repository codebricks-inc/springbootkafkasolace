package com.codebricks.kafkaapi.service;

import org.springframework.stereotype.Service;

import com.solace.messaging.MessagingService;
import com.solace.messaging.publisher.DirectMessagePublisher;
import com.solace.messaging.resources.Topic;

@Service
public class KafkaSolaceService {
	
	private final DirectMessagePublisher directMessagePublisher;
	
	public KafkaSolaceService(MessagingService messagingService) {
		this.directMessagePublisher = messagingService.createDirectMessagePublisherBuilder().build().start();
	}
	
	public void publish(String topic, String msg) {
		directMessagePublisher.publish(msg, Topic.of(topic));		
	}
	
}
