package com.xiaoxin.redis.component;

import com.xiaoxin.redis.model.BrandHotInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 上午11:07
 */
@Component
public class RedisZSetComponent {

    @Autowired
    private StringRedisTemplate template;

    public Set<String> findTopHotBrands(int userId){
        ZSetOperations ops = template.opsForZSet();
        Set<String> hotBrands = ops.reverseRange("design-pattern:brand:hot:"+userId,0,14);
        return hotBrands;
    }

    public boolean addBrandHot(BrandHotInfo brandHotInfo) {
        ZSetOperations ops = template.opsForZSet();
        boolean isSuccess =ops.incrementScore("design-pattern:brand:hot:"+brandHotInfo.getUserId(),
                brandHotInfo.getBrandName(),1)>0;
        return isSuccess;

    }

    public Set<String> rankByLexicographical(int userId){
        ZSetOperations ops = template.opsForZSet();
        // 按照存储顺序返回
        RedisZSetCommands.Range range =new  RedisZSetCommands.Range();
        Set<String> sortedSet =ops.rangeByLex("design-pattern:brand:hot:"+userId,range);
        return sortedSet;
    }

}
