package com.socialtouch.martech.mbase.dataimporter;

import com.socialtouch.martech.mbase.dataimporter.producer.ProducerWithLoop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaExamplesApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(KafkaExamplesApplication.class, args);
    }

}
