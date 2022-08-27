package com.javashitang.kafka.chapter_1_sync;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author lilimin
 * @Date 2022/8/27
 */
public class SyncProducer {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 5; i++) {
            RecordMetadata metadata = producer.send(new ProducerRecord<>("quickstart", "test" + i)).get();
            System.out.println("topic "+ metadata.topic());
            System.out.println("partition "+ metadata.partition());
            System.out.println("offset "+ metadata.offset());
        }

        producer.close();
    }
}
