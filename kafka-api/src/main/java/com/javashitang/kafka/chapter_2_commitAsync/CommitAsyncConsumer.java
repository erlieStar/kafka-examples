package com.javashitang.kafka.chapter_2_commitAsync;

import com.javashitang.kafka.chapter_0_quickstart.KafkaProperties;
import com.javashitang.kafka.chapter_3_interceptor.MyConsumerInterceptor;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @Author lilimin
 * @Date 2022/8/28
 */
public class CommitAsyncConsumer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.SERVER_URL);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaProperties.GROUP_ID);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, MyConsumerInterceptor.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(KafkaProperties.TOPIC));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record);
            }
            consumer.commitAsync(((offsets, exception) -> {
                if (exception == null) {
                    // 提交成功的逻辑
                    System.out.println(offsets);
                } else {
                    // 提交失败的逻辑
                    System.out.println(exception.getMessage());
                }
            }));
        }
    }
}
