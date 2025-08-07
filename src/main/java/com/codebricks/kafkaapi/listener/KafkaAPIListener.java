package com.codebricks.kafkaapi.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaAPIListener {

	@KafkaListener(topics = "employee-topic", groupId = "kafka-to-solace")
    public void consume(String message) {
        System.out.println("Received from Kafka: " + message);
    }
	
}
