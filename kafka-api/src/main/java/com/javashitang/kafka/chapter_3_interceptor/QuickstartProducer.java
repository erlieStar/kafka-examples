package com.javashitang.kafka.chapter_3_interceptor;


import com.javashitang.kafka.chapter_0_quickstart.KafkaProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author lilimin
 * @Date 2022/8/27
 */
public class QuickstartProducer {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.SERVER_URL);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, MyProducerInterceptor.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 5; i++) {
            RecordMetadata metadata = producer.send(new ProducerRecord<>(KafkaProperties.TOPIC, "test" + i)).get();
            System.out.printf("topic: %s, partition: %s, offset: %s %n", metadata.topic(), metadata.partition(), metadata.offset());
        }

        producer.close();
    }
}
