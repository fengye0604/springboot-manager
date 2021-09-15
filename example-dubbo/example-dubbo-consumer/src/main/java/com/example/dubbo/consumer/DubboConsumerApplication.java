package com.example.dubbo.consumer;

//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.dubbo.consumer
 * @author:yanggaoli
 * @createTime:2021/9/10 0:04
 * @version:1.0
 */
@SpringBootApplication
@EnableDubbo
@ComponentScan(basePackages = {"com.example.dubblo"})
public class DubboConsumerApplication {
    public static void main(String[] args){
        SpringApplication.run(DubboConsumerApplication.class,args);
    }
}
