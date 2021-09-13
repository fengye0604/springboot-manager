package com.example.examplerocketmqconsumer.config;

public class JmsConfig {
    /**
     * Name Server 地址，因为是集群部署 所以有多个用 分号 隔开
     */
    public static final String NAME_SERVER = "123.57.91.202:9876";
    /**
     * 主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（ 如果没有创建好，生产者往该主题发送消息 会报找不到topic错误）
     */
//    public static final String TOPIC = "topic_family";
    public static final String TOPIC = "TopicTest";

}