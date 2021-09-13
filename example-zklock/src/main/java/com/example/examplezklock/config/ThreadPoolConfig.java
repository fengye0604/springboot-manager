package com.example.examplezklock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplezklock.config
 * @author:yanggaoli
 * @createTime:2021/9/4 23:15
 * @version:1.0
 */
@Configuration
public class ThreadPoolConfig {
    @Bean
    public ThreadPoolExecutor createThreadPoolExecutor(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 8,
                0L,TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(100));
        return threadPoolExecutor;
    }


}
