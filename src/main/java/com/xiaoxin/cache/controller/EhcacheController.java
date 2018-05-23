package com.xiaoxin.cache.controller;

import com.xiaoxin.cache.model.Token;
import com.xiaoxin.cache.service.TokenService;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/5/23 上午10:44
 */
@RestController
@RequestMapping("ehcache")
public class EhcacheController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/generateToken")
    public Result generateToken(@RequestBody String userId) {
        Token token = new Token(new Date(), userId);
        String tokenStr = tokenService.generateToken(token);
        return ResultGenerator.genSuccessResult(tokenStr);
    }

    @PostMapping("/parseToken")
    public Result parseToken(@RequestBody String tokenStr) {
        Token token = tokenService.parseToken(tokenStr);
        return ResultGenerator.genSuccessResult(token);
    }

    @PostMapping("/clearTokenCache")
    public Result clearTokenCache() {
        tokenService.clearCache();
        return ResultGenerator.genSuccessResult();
    }
}
