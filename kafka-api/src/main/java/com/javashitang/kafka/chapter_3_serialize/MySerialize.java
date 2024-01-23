package com.javashitang.kafka.chapter_3_serialize;

import com.alibaba.fastjson2.JSON;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @Author lilimin
 * @Date 2023/5/2
 */
public class MySerialize implements Serializer<User> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, User data) {
        return JSON.toJSONBytes(data);
    }

    @Override
    public void close() {

    }
}
