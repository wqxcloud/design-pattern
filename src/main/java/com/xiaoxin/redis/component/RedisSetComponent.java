package com.xiaoxin.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 下午8:11
 */
@Component
public class RedisSetComponent {

    @Autowired
    private RedisTemplate redisTemplate;




}
