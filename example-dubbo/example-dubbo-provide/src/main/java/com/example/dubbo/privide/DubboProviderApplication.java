package com.example.dubbo.privide;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.dubbo.privide
 * @author:yanggaoli
 * @createTime:2021/9/10 0:15
 * @version:1.0
 */
@SpringBootApplication
@EnableDubbo
public class DubboProviderApplication {
    public static void main(String[] args){
        SpringApplication.run(DubboProviderApplication.class,args);
    }
}
