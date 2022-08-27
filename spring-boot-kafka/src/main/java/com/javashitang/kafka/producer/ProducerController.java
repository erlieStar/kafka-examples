package com.javashitang.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: lilimin
 * @Date: 2019/4/25 15:41
 */
@RestController
public class ProducerController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("sendMsg")
    public String sendMsg(String msg) {
        kafkaTemplate.send("quickStart", msg);
        return "success";
    }

}
