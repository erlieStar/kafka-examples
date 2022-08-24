package com.javashitang.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class ProducerWithLoop {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void test() {
        int messageNo = 0;
        while (true) {
            String messageStr = "message-" + messageNo;
            kafkaTemplate.send("test_concurrent", messageStr, messageStr);
            ++messageNo;
        }
    }

}
