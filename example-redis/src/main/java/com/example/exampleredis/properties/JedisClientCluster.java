package com.example.exampleredis.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
public class JedisClientCluster implements JedisClient {
    @Autowired
    private JedisCluster jedisCluster;

//    设置key
    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

//    获取key
    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

//    判断key在不在
    @Override
    public Boolean exists(String key) {
        return jedisCluster.exists(key);
    }

//    设置key的过期时间
    @Override
    public Long expire(String key, int seconds) {
        return jedisCluster.expire(key, seconds);
    }


    @Override
    public Long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    @Override
    public Long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return jedisCluster.hset(key, field, value);
    }

    @Override
    public String hget(String key, String field) {
        return jedisCluster.hget(key, field);
    }

//    删除key
    @Override
    public Long hdel(String key, String... field) {
        return jedisCluster.hdel(key, field);
    }

    public Long hdel1(String key, String... field) {
        return jedisCluster.zadd("",1000,"");
    }

}