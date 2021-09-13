package com.example.job.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.job.scheduled
 * @author:yanggaoli
 * @createTime:2021/7/18 17:48
 * @version:1.0
 */
@EnableScheduling
@SpringBootApplication
public class ScheduledApplication {
    public static void main(String[] args){
        SpringApplication.run(ScheduledApplication.class,args);
    }
}
