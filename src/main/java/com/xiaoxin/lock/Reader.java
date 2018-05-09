package com.xiaoxin.lock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/5/8 下午7:56
 */
@Slf4j
@AllArgsConstructor
public class Reader implements Runnable {
    private Money money;

    @Override
    public void run() {
        Bank bank = new Bank();
        bank.check(money);
    }
}