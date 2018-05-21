package com.xiaoxin.rmi.service.impl;

import com.xiaoxin.rmi.model.Account;
import com.xiaoxin.rmi.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午3:36
 */
@Service("accountService")
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Override
    public void addAccount(Account account) {
        log.info("can access AccountServiceImpl.addAccount");
    }
}
