package com.example.examplezklock.service;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 实现了ApplicationRunner接口后，当容器启动后，会执行实现的run方法
 *
 * @author 594781919
 */
@Service
@Order(value = 2)
public class ApplicationRunnerService2 implements ApplicationRunner {



    @Override
    public void run(ApplicationArguments applicationArguments) {
        System.out.println("ApplicationRunnerService2--------------------------");
    }
}
