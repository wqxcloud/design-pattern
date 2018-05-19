package com.xiaoxin.redis.controller;

import com.xiaoxin.model.UserInfo;
import com.xiaoxin.redis.RedisHashComponent;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 下午4:42
 */
@RestController
@RequestMapping("hash")
public class RedisHashController {
    @Autowired
    private RedisHashComponent hashComponent;

    @PostMapping("/addOne")
    public Result addUserInfo(@RequestBody UserInfo userInfo){
        hashComponent.addUserInfo(userInfo);

        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/getUserInfos")
    public Result getUserInfos(@RequestBody List<String> ids){
        List<UserInfo> userInfos =hashComponent.getUserInfos(ids);
        return ResultGenerator.genSuccessResult(userInfos);
    }
}
