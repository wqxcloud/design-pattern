package com.xiaoxin.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 下午8:11
 */
@Component
public class RedisSetComponent {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void add(String key,String[] values) {
       SetOperations operations = redisTemplate.opsForSet();
       assert values!=null && values.length>0;
       for(String value:values){
           operations.add(key,value);
       }
    }

    /**
     * 左边的set去掉右边和左边交集的部分
     * @param key1
     * @param key2
     * @return
     */
    public Set<String> diff(String key1, String key2){
        SetOperations operations = redisTemplate.opsForSet();
        return operations.difference(key1,key2);
    }

    /**
     * 并集
     * @param key1
     * @param key2
     * @return
     */
    public Set<String> union(String key1, String key2){
        SetOperations operations = redisTemplate.opsForSet();
        return operations.union(key1,key2);
    }

    /**
     * 交集
     * @param key1
     * @param key2
     * @return
     */
    public Set<String> join(String key1, String key2){
        SetOperations operations = redisTemplate.opsForSet();
        return operations.intersect(key1,key2);
    }

    /**
     * 随机消费，模拟抽奖
     * @param key
     * @return
     */
    public String pop(String key){
        SetOperations operations = redisTemplate.opsForSet();
        return (String) operations.pop(key);
    }
}
