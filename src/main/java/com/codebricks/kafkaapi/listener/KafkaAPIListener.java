package com.codebricks.kafkaapi.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.codebricks.kafkaapi.service.KafkaSolaceService;

@Service
public class KafkaAPIListener {

	@Autowired
	private KafkaSolaceService kafkaSolaceService;
	
	@KafkaListener(topics = "employee-topic", groupId = "kafka-to-solace")
    public void consume(String message) {
        System.out.println("Received from Kafka: " + message);
        kafkaSolaceService.publish("employee/solace", message); // or your desired Solace topic
    }
	
}
