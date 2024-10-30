package com.kafka.demo.rest;

import com.kafka.demo.payload.Student;
import com.kafka.demo.producer.KafkaJsonProducer;
import com.kafka.demo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;
    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent");
    }
    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message){
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("message sent");
    }
}
