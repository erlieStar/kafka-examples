package com.javashitang.kafka.chapter_3_interceptor;

import com.javashitang.kafka.chapter_0_quickstart.KafkaProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
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
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.SERVER_URL);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaProperties.GROUP_ID);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, MyConsumerInterceptor.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(KafkaProperties.TOPIC));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record);
            }
        }
    }
}
