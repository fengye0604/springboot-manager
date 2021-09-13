package com.example.exampleredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ExampleRedisApplication {
    public static void main(String[] args){
        SpringApplication.run(ExampleRedisApplication.class,args);
    }
}
