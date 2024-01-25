package com.javashitang.kafka.chapter_3_interceptor;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author lilimin
 * @Date 2023/4/16
 */
public class MyConsumerInterceptor implements ConsumerInterceptor<String, String> {

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        System.out.println("收到消息开始消费之前调用");
        return records;
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
        System.out.println("提交位移之后调用");
    }

    @Override
    public void close() {
        System.out.println("拦截器关闭时调用");
    }

    @Override
    public void configure(Map<String, ?> configs) {
        System.out.println("拦截器实例创建后调用，用于配置拦截器");
    }
}
