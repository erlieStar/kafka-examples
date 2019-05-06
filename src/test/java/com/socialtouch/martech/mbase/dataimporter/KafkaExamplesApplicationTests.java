package com.socialtouch.martech.mbase.dataimporter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaExamplesApplicationTests {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void contextLoads() {
        int messageNo = 0;
        while (true) {
            String messageStr = "message-" + messageNo;
            kafkaTemplate.send("test_concurrent", messageStr, messageStr);
            ++messageNo;
            System.out.println(messageNo);
        }
    }

}
