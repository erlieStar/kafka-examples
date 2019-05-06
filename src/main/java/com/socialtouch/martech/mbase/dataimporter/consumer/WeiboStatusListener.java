package com.socialtouch.martech.mbase.dataimporter.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lilimin
 * @Date: 2019/4/25 15:41
 */
@Component
public class WeiboStatusListener {

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WeiboStatusListener.class);


    @KafkaListener(topics = {"test_concurrent"})
    public void listen(List<ConsumerRecord<Long, String>> recordList) {

        logger.debug("Receive status list, size: " + recordList.size());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (ConsumerRecord<Long, String> record : recordList) {
            System.out.println(record.value());
        }

    }
}
