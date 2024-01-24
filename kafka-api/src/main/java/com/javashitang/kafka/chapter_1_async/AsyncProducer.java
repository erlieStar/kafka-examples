package com.javashitang.kafka.chapter_1_async;

import com.javashitang.kafka.chapter_0_quickstart.KafkaProperties;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author lilimin
 * @Date 2022/8/27
 */
public class AsyncProducer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.SERVER_URL);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 5; i++) {
            producer.send(new ProducerRecord<>(KafkaProperties.TOPIC, "test" + i), (recordMetadata, exception) -> {
                if (exception != null) {
                    System.out.println(exception.getMessage());
                }
            });
        }

        producer.close();
    }
}
