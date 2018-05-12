package com.xiaoxin.current.cyclicbarrier;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther zhangyongxin
 * @date 2018/5/8 下午7:59
 */
@Slf4j
@AllArgsConstructor
public class Producer implements Runnable, Callable {
    private Money money;
    private CyclicBarrier cyclicBarrier;

    @Override
    public void run() {
        Bank bank = new Bank();
        try {
            for (int i = 0; i < 100; i++) {
                bank.put(money);
            }
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() throws Exception {
        Bank bank = new Bank();
        try {
            for (int i = 0; i < 100; i++) {
                bank.put(money);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return money;
    }
}
