package com.xiaoxin.listener.controller;

import com.xiaoxin.listener.service.StockInService;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/5/30 下午4:21
 */
@RestController
@RequestMapping("listener")
public class ListenerController {

    @Autowired
    private StockInService stockInService;

    @Autowired
    @Qualifier("stockInEventBusDrivenService")
    private StockInService stockInEventBusDrivenService;

    @GetMapping("/testJavaBased")
    public Result testJavaBased(){
        stockInService.stockIn();
        return ResultGenerator.genSuccessResult(new Date());
    }
    @GetMapping("/testGuavaBased")
    public Result testGuavaBased(){
        stockInEventBusDrivenService.stockIn();
        return ResultGenerator.genSuccessResult(new Date());
    }
}
