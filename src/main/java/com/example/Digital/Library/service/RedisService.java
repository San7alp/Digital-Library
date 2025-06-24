package com.example.Digital.Library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private final RedisTemplate<String,Object> redisTemplate;
    @Autowired
    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public void add2Cache(String key,String value){
        this.redisTemplate.opsForValue().set(key,value,10, TimeUnit.MINUTES);
    }
    public Object getCacheData(String key){
        return this.redisTemplate.opsForValue().get(key);
    }
    public void deleteFromCache(String key){
        this.redisTemplate.delete(key);
    }
}
