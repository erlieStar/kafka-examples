package com.javashitang.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: lilimin
 * @Date: 2019/4/25 15:41
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"quickStart"})
    public void listen(String msg) {
        System.out.println("收到消息 " + msg);
    }
}
