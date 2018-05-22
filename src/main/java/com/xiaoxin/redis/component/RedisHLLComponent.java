package com.xiaoxin.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 下午8:12
 */
@Component
public class RedisHLLComponent {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 可以在查看非详情时快速查看数量，类似粉丝数这样的值可以保存，或许使用计数器？
     * @param key
     * @return
     */
    public Long size(String key) {
        HyperLogLogOperations ops = redisTemplate.opsForHyperLogLog();
        return ops.size(key);
    }

    public void add(String key,String[] values){
        assert null!=values && values.length!=0;
        HyperLogLogOperations ops = redisTemplate.opsForHyperLogLog();
        for(String value :values){
            ops.add(key,value);
        }
    }
}
