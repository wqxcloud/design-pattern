package com.xiaoxin.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 解决乱码问题,使用StringRedisTemplate则不会出现乱码问题
 * @Auther zhangyongxin
 * @date 2018/5/19 下午8:03
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate redisTemplateInit(RedisTemplate redisTemplate) {
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
