package com.example.deliciousfoods.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setValue(String key, Object val){
        redisTemplate.opsForValue().set(key, val);
    }

    public void setValue(String key, Object val, int time){
        redisTemplate.opsForValue().set(key, val, time, TimeUnit.SECONDS);
    }

    public Object getValue(String key){
       return redisTemplate.opsForValue().get(key);
    }

    public boolean hasKey(String key){
        return  redisTemplate.hasKey(key);
    }

    public void setHash(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public Object getHash(String key, String prop) {
        return redisTemplate.opsForHash().get(key, prop);
    }

    public List<Object> multiGet(Collection<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }
    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, int time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
