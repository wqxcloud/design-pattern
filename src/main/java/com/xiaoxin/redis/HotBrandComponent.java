package com.xiaoxin.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 上午11:07
 */
@Component
public class HotBrandComponent {

    @Autowired
    private StringRedisTemplate template;

    public Set<String> findTopHotBrands(int userId){
        ZSetOperations ops = template.opsForZSet();
        Set<String> hotBrands = ops.reverseRange("brand:hot:"+userId,0,14);
        return hotBrands;
    }

    public boolean addBrandHot(BrandHotInfo brandHotInfo) {
        ZSetOperations ops = template.opsForZSet();
        boolean isSuccess = false;
        isSuccess =ops.incrementScore("brand:hot:"+brandHotInfo.getUserId(),
                brandHotInfo.getBrandName(),1)>0;
        return isSuccess;

    }
}
