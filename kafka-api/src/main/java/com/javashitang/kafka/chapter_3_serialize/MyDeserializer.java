package com.javashitang.kafka.chapter_3_serialize;

import com.alibaba.fastjson2.JSON;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @Author lilimin
 * @Date 2023/5/2
 */
public class MyDeserializer implements Deserializer<User> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public User deserialize(String topic, byte[] data) {
        return JSON.parseObject(data, User.class);
    }

    @Override
    public void close() {

    }
}
