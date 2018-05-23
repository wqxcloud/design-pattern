package com.xiaoxin.cache.service.impl;

import com.google.gson.Gson;
import com.xiaoxin.cache.model.Token;
import com.xiaoxin.cache.service.TokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * spring-boot-starter-cache
 * 支持多种cache：
 * Generic
 * JCache (JSR-107) (EhCache 3, Hazelcast, Infinispan, etc)
 * EhCache 2.x
 * Hazelcast
 * Infinispan
 * Couchbase
 * Redis
 * Caffeine
 * Guava (deprecated)
 * Simple
 * 现在测试了两个：ehcache和redis
 * ehcache配置项：#spring.cache.ehcache.config=classpath:ehcache.xml
 * redis配置项：
 * spring.redis.host=localhost
 * spring.redis.password=
 * spring.redis.port=6379
 * spring.redis.timeout=
 * spring.redis.database=6
 *
 * @Auther zhangyongxin
 * @date 2018/5/23 上午9:58
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Value("${jwt.token.security}")
    private String base64Security;

    @Override
    @Cacheable(value = "design-pattern:Token:generateToken",key="#token.getUserId()")
    public String generateToken(Token token) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setPayload(new Gson().toJson(token))
                .signWith(signatureAlgorithm,base64Security.getBytes());
        //生成JWT
        return builder.compact();
    }

    @Override
    public Token parseToken(String tokenStr) {
        Map<String,Object> claims = Jwts.parser()
                .setSigningKey(base64Security.getBytes())
                .parseClaimsJws(tokenStr).getBody();
        Date createDate = new Date((String)claims.get("createDate"));
        Token token = new Token(createDate,(String)claims.get("userId"));
        return token;
    }

    @Override
    @CacheEvict(cacheNames = "Token",allEntries = true)
    public void clearCache() {
        log.info("cleared all Token cache ");
    }
}
