package com.javashitang.kafka.chapter_3_interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author lilimin
 * @Date 2023/4/16
 */
public class MyProducerInterceptor implements ProducerInterceptor<String, String> {

    private int errorCount = 0;
    private int successCount = 0;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        System.out.println("消息发送之前被调用");
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        System.out.println("消息被发送到分区之后或者发送失败被调用");
        if (exception == null) {
            successCount++;
        } else {
            errorCount++;
        }
    }

    @Override
    public void close() {
        System.out.println("拦截器关闭时调用");
        System.out.println("success count " + successCount);
        System.out.println("error count " + errorCount);
    }

    @Override
    public void configure(Map<String, ?> configs) {
        System.out.println("拦截器实例创建后调用，用于配置拦截器");
    }
}
