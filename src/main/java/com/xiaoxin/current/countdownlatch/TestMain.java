package com.xiaoxin.current.countdownlatch;

import com.xiaoxin.current.lock.Money;
import com.xiaoxin.current.lock.Producer;
import com.xiaoxin.current.lock.Reader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Auther zhangyongxin
 * @date 2018/5/12 下午2:11
 */
@Slf4j
public class TestMain {

    /**
     * countDownLatch 可以实现多个线程同时执行，之后完毕后加入主线程，实现异步后同步的操作
     * @throws InterruptedException
     */
    @Test
    public void testJoin() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        Money money = new Money();
        Producer producer = new Producer(money,countDownLatch);
        Reader reader = new Reader(money,countDownLatch);
        Thread task1 = new Thread(producer);
        Thread task3 = new Thread(producer);
        Thread task2 = new Thread(reader);

        task1.start();
        task3.start();
        task2.start();

        countDownLatch.await();
        log.info("我到底还剩多少钱？"+money.getAmount());

    }
}
