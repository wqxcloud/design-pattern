package com.xiaoxin.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 下午8:11
 */
@Component
public class RedisValueComponent {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addValue(String key,String value){
        ValueOperations valueOperations =redisTemplate.opsForValue();
        valueOperations.append(key,value);
    }

    /**
     * 点赞系统
     * @param key
     * @return
     */
    public Long increment(String key){
        ValueOperations valueOperations =redisTemplate.opsForValue();
        //初始值为0
        if (null==valueOperations.get(key)) {
            valueOperations.set(key,0);
        }
        // 增量为 1
        Long current = valueOperations.increment(key,1);
        return current;
    }
    public void multiSet(Map<String,String> map){
        ValueOperations valueOperations =redisTemplate.opsForValue();
        valueOperations.multiSet(map);
    }

    public String getAndSet(String key,String value){
        ValueOperations valueOperations =redisTemplate.opsForValue();
        String returnValue = (String) valueOperations.getAndSet(key,value);
        return returnValue;
    }

    public String get(String key){
        ValueOperations valueOperations =redisTemplate.opsForValue();
        String returnValue = (String) valueOperations.get(key);
        return returnValue;
    }

    public List<String> multiGet(List<String> keys){
        ValueOperations valueOperations =redisTemplate.opsForValue();
        List<String> returnValues =  valueOperations.multiGet(keys);
        return returnValues;
    }
}
