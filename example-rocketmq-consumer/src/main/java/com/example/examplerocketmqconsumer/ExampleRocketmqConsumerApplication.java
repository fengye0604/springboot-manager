package com.example.examplerocketmqconsumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.examplerocketmqconsumer.dao.mysql")
public class ExampleRocketmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleRocketmqConsumerApplication.class, args);
    }

}
