package com.xiaoxin.redis.controller;

import com.xiaoxin.redis.component.RedisHLLComponent;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther zhangyongxin
 * @date 2018/5/20 下午2:41
 */
@RestController
@RequestMapping("hll")
public class RedisHLLController {

    @Autowired
    private RedisHLLComponent hllComponent;

    @GetMapping("/size")
    public Result size(String key){
       long size= hllComponent.size(key);
       return ResultGenerator.genSuccessResult(size);
    }

    @PostMapping("/add/{key}")
    public Result add(@PathVariable String key,@RequestBody String[] values){
        hllComponent.add(key,values);
        return ResultGenerator.genSuccessResult();
    }

}
