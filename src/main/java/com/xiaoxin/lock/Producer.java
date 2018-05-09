package com.xiaoxin.lock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/5/8 下午7:59
 */
@AllArgsConstructor
@Slf4j
public class Producer implements Runnable {
    private Money money;

    @Override
    public void run() {
        Bank bank = new Bank();
        try {
           for (int i= 0;i<100;i++){
               bank.put(money);
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
