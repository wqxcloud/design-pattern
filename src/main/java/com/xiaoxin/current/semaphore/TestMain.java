package com.xiaoxin.current.semaphore;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/5/13 下午6:29
 */
@Slf4j
public class TestMain {
    /**
     * 信号量：Semaphore是用来保护一个或者多个共享资源的访问，Semaphore内部维护了一个计数器，
     * 其值为可以访问的共享资源的个数。
     * 一个线程要访问共享资源，先获得信号量，如果信号量的计数器值大于1，
     * 意味着有共享资源可以访问，则使其计数器值减去1，再访问共享资源。
     *
     * 如果计数器值为0,线程进入休眠。
     * 当某个线程使用完共享资源后，释放信号量，
     * 并将信号量内部的计数器加1，之前进入休眠的线程将被唤醒并再次试图获得信号量。
     */
    @Test
    public void testSemaphore() throws InterruptedException {
        Bank bank = new Bank(4);
        Producer producer = new Producer(new Money(0),bank);
        Reader reader = new Reader(new Money(20),bank);
        Thread task1 = new Thread(producer);
        Thread task3 = new Thread(producer);
        Thread task2 = new Thread(reader);
        Thread task4 = new Thread(producer);

        task1.start();
        task3.start();
        task2.start();
        task4.start();

        task1.join();
        task2.join();
        task3.join();
        task4.join();
        log.info(".....");
    }
}
