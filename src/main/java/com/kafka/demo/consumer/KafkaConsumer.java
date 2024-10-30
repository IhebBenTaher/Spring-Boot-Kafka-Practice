package com.kafka.demo.consumer;

import com.kafka.demo.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    //@KafkaListener(topics = "testTopic",groupId = "myGroup")
    public void consumeMessage(String msg){
        log.info(String.format("consume msg: %s",msg));
    }
    @KafkaListener(topics = "testTopic",groupId = "myGroup")
    public void consumeJsonMessage(Student msg){
        log.info(String.format("consume msg: %s",msg));
    }
}
