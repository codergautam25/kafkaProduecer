package com.example.kafka.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    private final String TOPIC = "producer_test";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        int messageSize = message.getBytes().length;
        System.out.println("Message size: " + messageSize + " bytes");  // Log the message size
        kafkaTemplate.send(TOPIC, message);
        return "Message sent to Kafka: " + message;
    }
}

