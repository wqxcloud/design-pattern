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
        long start = System.currentTimeMillis();
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
        /**
         * cyclicBarrier和countDownLatch共同点和区别
         * 共同点：都能实现多个线程先异步执行，再同步的功能
         * 区别：countDownLatch是计数器的体现，执行await的方法等待其他执行countDown方法的线程执行完毕后执行，
         * cyclicBarrier需要所有线程到达barrier状态后再执行后续操作,否则会一致处于等待状态；
         * 如果仅仅需要实现先异步执行再同步的功能countDownLatch效率会高一些
         */
        log.info("用时"+(System.currentTimeMillis()-start));
    }
}
