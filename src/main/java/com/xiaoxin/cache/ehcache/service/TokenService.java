package com.xiaoxin.cache.ehcache.service;

import com.xiaoxin.cache.ehcache.model.Token;

/**
 * @Auther zhangyongxin
 * @date 2018/5/23 上午9:57
 */
public interface TokenService {

    String generateToken(Token token);


    Token parseToken(String tokenStr);

    void clearCache();
}
