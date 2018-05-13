package com.xiaoxin.current.semaphore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/5/8 下午7:56
 */
@Slf4j
@Getter
@Setter
public class Reader extends Customer {


    public Reader(Money money, Bank bank) {
        super(money, bank);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                bank.check(this);
            }
//            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
