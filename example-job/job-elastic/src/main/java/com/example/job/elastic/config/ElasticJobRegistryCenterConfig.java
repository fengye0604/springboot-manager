package com.example.job.elastic.config;



import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticJobRegistryCenterConfig {

    //zookeeper链接字符串 localhost:2181
    private  String ZOOKEEPER_CONNECTION_STRING = "121.4.53.134:2181" ;
//    private  String ZOOKEEPER_CONNECTION_STRING = "123.57.91.202:2182,123.57.91.202:2183,123.57.91.202:2184" ;
    //定时任务命名空间
    private  String JOB_NAMESPACE = "elastic-job";

    @Bean(initMethod = "init")
    public CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
                new ZookeeperConfiguration(
                        ZOOKEEPER_CONNECTION_STRING,
                        JOB_NAMESPACE
                )
        );
        return regCenter;
    }
}
