package com.xiaoxin.redis.controller;

import com.xiaoxin.redis.component.RedisValueComponent;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/5/20 上午10:00
 */
@RestController
@RequestMapping("value")
public class RedisValueController {

    @Autowired
    private RedisValueComponent valueComponent;

    @PostMapping("/getAndSet/{key}/{value}")
    public Result getAndSet(@PathVariable String key, @PathVariable String value){
        String resultVal =valueComponent.getAndSet(key,value);
        return ResultGenerator.genSuccessResult(resultVal);
    }

    @PostMapping("/multiGet")
    public Result multiGet(@RequestBody List<String> keys){
        List<String> values =valueComponent.multiGet(keys);
        return ResultGenerator.genSuccessResult(values);
    }

    @PostMapping("/increment/{key}")
    public Result increment(@PathVariable String key){
        Long current =valueComponent.increment(key);
        return ResultGenerator.genSuccessResult(current);
    }

}
