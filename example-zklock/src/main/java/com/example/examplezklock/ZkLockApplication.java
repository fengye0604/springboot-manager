package com.example.examplezklock;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplezklock
 * @author:yanggaoli
 * @createTime:2021/9/4 16:09
 * @version:1.0
 */
@EnableScheduling
@EnableJpaAuditing
@EnableApolloConfig
@SpringBootApplication
public class ZkLockApplication {
    public static void main(String[] args){
        SpringApplication.run(ZkLockApplication.class,args);
    }
}
