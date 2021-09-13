package com.example.examplerocketmqproducer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.examplerocketmqproducer.dao.oracle")
public class ExampleRocketmqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleRocketmqProducerApplication.class, args);
    }

}
