package com.xiaoxin.redis.controller;

import com.xiaoxin.redis.component.RedisSetComponent;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @Auther zhangyongxin
 * @date 2018/5/20 上午11:57
 */
@RestController
@RequestMapping("set")
public class RedisSetController {

    @Autowired
    private RedisSetComponent setComponent;

    @PostMapping("/add/{key}")
    public Result add(@PathVariable String key,@RequestBody String[] values){
        setComponent.add(key,values);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/pop")
    public Result pop(String key){
        String value =setComponent.pop(key);
        return ResultGenerator.genSuccessResult(value);
    }

    @GetMapping("/join")
    public Result join(String key1,String key2){
        Set<String> value =setComponent.join(key1,key2);
        return ResultGenerator.genSuccessResult(value);
    }

    @GetMapping("/diff")
    public Result diff(String key1,String key2){
        Set<String> value =setComponent.diff(key1,key2);
        return ResultGenerator.genSuccessResult(value);
    }

    @GetMapping("/union")
    public Result union(String key1,String key2){
        Set<String> value =setComponent.union(key1,key2);
        return ResultGenerator.genSuccessResult(value);
    }

}
