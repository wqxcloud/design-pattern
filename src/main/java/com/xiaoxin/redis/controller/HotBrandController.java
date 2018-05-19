package com.xiaoxin.redis.controller;

import com.xiaoxin.redis.BrandHotInfo;
import com.xiaoxin.redis.HotBrandComponent;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 上午11:20
 */
@RequestMapping("hotBrand")
@RestController
public class HotBrandController {
    @Autowired
    private HotBrandComponent hotBrandComponent;

    @GetMapping("/findTopHot/{id}")
    public Result findTopHotBrandByUserId(@PathVariable int id){
        return ResultGenerator.genSuccessResult(hotBrandComponent.findTopHotBrands(id));
    }

    @PostMapping("/addBrandHot")
    public Result addBrandHot(@RequestBody BrandHotInfo brandHotInfo){
        return ResultGenerator.genSuccessResult(hotBrandComponent.addBrandHot(brandHotInfo));
    }
}
