package com.example.exampleapollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
@MapperScan("com.example.exampleapollo.dao")
public class ApolloApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class,args);
    }
}
