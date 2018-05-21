package com.xiaoxin.rmi.controller;

import com.xiaoxin.rmi.model.Account;
import com.xiaoxin.rmi.service.AccountService;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午4:09
 */
@RestController
@RequestMapping("account")
public class AccountClientController {

    // 因为本系统声明了两个AccountService类型的bean，实际在客户端最多一个
    @Autowired
    @Qualifier("clientAccountService")
    private AccountService clientAccountService;


    @PostMapping("/addOne")
    public Result addAccount(){
        clientAccountService.addAccount(new Account());
        return ResultGenerator.genSuccessResult();
    }
}
