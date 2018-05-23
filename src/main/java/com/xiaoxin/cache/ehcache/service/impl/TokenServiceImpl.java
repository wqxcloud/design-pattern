package com.xiaoxin.cache.ehcache.service.impl;

import com.google.gson.Gson;
import com.xiaoxin.cache.ehcache.model.Token;
import com.xiaoxin.cache.ehcache.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther zhangyongxin
 * @date 2018/5/23 上午9:58
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Value("${jwt.token.security}")
    private String base64Security;

    @Override
    @Cacheable(value = "Token",key="#token.getUserId()")
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
