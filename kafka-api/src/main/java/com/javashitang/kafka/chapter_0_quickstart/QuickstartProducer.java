package com.javashitang.kafka.chapter_0_quickstart;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author lilimin
 * @Date 2022/8/27
 */
public class QuickstartProducer {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.128:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 5; i++) {
            RecordMetadata recordMetadata = producer.send(new ProducerRecord<>("quickstart", "test" + i)).get();
            System.out.println("partition " + recordMetadata.partition() + " offset " + recordMetadata.offset());
        }

        producer.close();
    }
}
