package com.javashitang.kafka.chapter_3_serialize;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * @Author lilimin
 * @Date 2022/8/27
 */
public class QuickstartConsumer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.128:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "quickstartGroup");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MyDeserializer.class.getName());

        KafkaConsumer<String, User> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("quickstart"));

        while (true) {
            ConsumerRecords<String, User> records = consumer.poll(1000);

            for (ConsumerRecord<String, User> record : records) {
                System.out.println(record);
            }
        }
    }
}
