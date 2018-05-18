package com.xiaoxin.validator.controller;

import com.xiaoxin.model.UserInfo;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import com.xiaoxin.validator.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther zhangyongxin
 * @date 2018/5/18 下午8:09
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/findOne/{id}")
    public Result findUserInfo(@PathVariable int id){
        return ResultGenerator.genSuccessResult(userInfoService.queryUserInfo(id));
    }

    @PostMapping("/addOne")
    public Result addUserInfo(@RequestBody UserInfo userInfo){
        int id =userInfoService.addUserInfo(userInfo);
        return ResultGenerator.genSuccessResult(id);
    }


}
