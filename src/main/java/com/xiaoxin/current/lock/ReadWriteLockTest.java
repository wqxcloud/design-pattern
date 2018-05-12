package com.xiaoxin.current.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试读写锁
 *
 * @Auther zhangyongxin
 * @date 2018/5/8 下午5:10
 */
@Slf4j
public class ReadWriteLockTest {

    @Test
    public void testLock() throws InterruptedException {
        Money money = new Money();
        Producer producer = new Producer(money);
        Reader reader = new Reader(money);
        Thread thread1 = new Thread(producer,"生产者");
        Thread thread2 = new Thread(reader,"消费者");
        thread2.start();
        thread1.start();
        Thread.sleep(3000);
        log.info("我到底还剩多少钱？"+money.getAmount());
    }
}
