package com.example.examplezklock.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplezklock.config
 * @author:yanggaoli
 * @createTime:2021/9/4 16:12
 * @version:1.0
 */
@Configuration
public class CuratorConfig {
    @Bean
    public CuratorFramework curatorFramework() {
        /**
         * curator链接zookeeper的策略:RetryNTimes
         * n：重试的次数
         * sleepMsBetweenRetries：每次重试间隔的时间
         */
        RetryNTimes retryNTimes = new RetryNTimes(5, 1000);
        return CuratorFrameworkFactory.newClient("121.4.53.134.:2181",retryNTimes );
    }
}
