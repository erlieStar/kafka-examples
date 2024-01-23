package com.javashitang.kafka.chapter_3_serialize;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author lilimin
 * @Date 2023/5/2
 */
@Data
@AllArgsConstructor
public class User {

    private Long id;

    private String name;
}
