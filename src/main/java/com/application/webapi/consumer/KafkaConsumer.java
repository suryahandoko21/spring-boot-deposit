package com.application.webapi.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "ProduceTopic", groupId = "group_id")
    public void consume(String message)
    {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(">>>> message stream from kafka <<<< " + message);
        System.out.println("------------------------------------------------------------------------");
    }
}