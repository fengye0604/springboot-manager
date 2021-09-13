package com.example.examplezklock.service;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * 实现了ApplicationRunner接口后，当容器启动后，会执行实现的run方法
 *
 * @author 594781919
 */
@Service
public class StartService implements ApplicationRunner {

    @Autowired
    private CuratorFramework curatorFramework;

    @Autowired
    private ListenerService listenerService;

    @Override
    public void run(ApplicationArguments applicationArguments) {
		// 非常重要！！！Start the client. Most mutator methods will not work until the client is started
        curatorFramework.start();
        System.out.println("zookeeper client start");
        // 初始化监听方法
        listenerService.listener();
    }
}
