package com.xiaoxin.lock;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther zhangyongxin
 * @date 2018/5/8 下午7:54
 */
@Slf4j
@Getter
public class Bank {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public void check(Money money) {
        lock.readLock().lock();
        log.info("查看余额：" + money.getAmount());
        lock.readLock().unlock();

    }

    public void put(Money money) {
        lock.writeLock().lock();
        money.setAmount(money.getAmount() + 1);
        log.info("存了了一块钱;--------end---------查看余额：" + money.getAmount());
        lock.writeLock().unlock();
    }
}
