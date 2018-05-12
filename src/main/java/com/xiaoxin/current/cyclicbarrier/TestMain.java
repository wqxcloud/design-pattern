package com.xiaoxin.current.cyclicbarrier;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther zhangyongxin
 * @date 2018/5/12 下午4:47
 */
@Slf4j
public class TestMain {

    @Test
    public void testCyclicBarrier() throws BrokenBarrierException, InterruptedException {
        Money money = new Money();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable(){

            @Override
            public void run() {
                log.info("我现在还有多少钱？"+money.getAmount());
            }
        });

        Producer producer = new Producer(money,cyclicBarrier);
        Reader reader = new Reader(money,cyclicBarrier);
        Thread task1 = new Thread(producer);
        Thread task2 = new Thread(reader);
        Thread task3 = new Thread(producer);

        task1.start();
        task2.start();
        task3.start();
        cyclicBarrier.await();
    }
}
