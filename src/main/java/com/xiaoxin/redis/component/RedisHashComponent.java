package com.xiaoxin.redis.component;

import com.xiaoxin.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * hash可以存储object，用于缓存对象
 * @Auther zhangyongxin
 * @date 2018/5/19 下午4:31
 */
@Component
public class RedisHashComponent {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addUserInfo(UserInfo userInfo){
        HashOperations hashOperations= redisTemplate.opsForHash();
        hashOperations.put("design-pattern:user:userInfo",userInfo.getId().toString(),userInfo);
    }

    public List<UserInfo> getUserInfos(List<String> ids){
        HashOperations hashOperations= redisTemplate.opsForHash();
        List<UserInfo> userInfoList =hashOperations.multiGet("design-pattern:user:userInfo", ids);
        return userInfoList;
    }

}
