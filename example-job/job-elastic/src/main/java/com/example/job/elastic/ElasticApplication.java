package com.example.job.elastic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.elastic
 * @author:yanggaoli
 * @createTime:2021/7/18 22:19
 * @version:1.0
 */
@Slf4j
@SpringBootApplication
public class ElasticApplication {
    public static void main(String[] args){
        SpringApplication.run(ElasticApplication.class,args);
    }
}
