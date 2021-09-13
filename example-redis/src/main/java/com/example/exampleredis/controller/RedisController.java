package com.example.exampleredis.controller;

import com.example.exampleredis.config.RedisConfig;
import com.example.exampleredis.properties.JedisClientCluster;
import com.example.exampleredis.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisProperties redisProperties;

    @Autowired
    private JedisClientCluster jedisClientCluster;

    @RequestMapping("/getRedisValue")
    public String getRedisValue(){
        System.out.println(redisProperties.toString());
        System.out.println(jedisClientCluster.get("yp"));
        jedisClientCluster.set("12","12");
        System.out.println(jedisClientCluster.get("12"));
        return jedisClientCluster.hget("content","001");
    }
}