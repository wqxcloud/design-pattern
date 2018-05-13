package com.xiaoxin.current.semaphore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther zhangyongxin
 * @date 2018/5/8 下午7:54
 */
@Slf4j
@Getter
public class Bank {
    private int windowNum;

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 模拟银行的窗口2个，不保证先进先出
     */
    private Semaphore semaphore ;
    private LinkedBlockingQueue<BankWindow> windows;


    public Bank(int windowNum) {
        this.windowNum = windowNum;
        init();
    }

    public void init(){
        windows=new LinkedBlockingQueue(windowNum);
        for (int i = 0; i < windowNum; i++) {
            windows.offer(new BankWindow());
        }
       semaphore = new Semaphore(windowNum,false);
    }


    public void check(Customer customer) throws InterruptedException {
        /**
         * 使用阻塞队列进行数量控制
         */
//        BankWindow window =useBankWindow();
//        window.check(customer);
        /**
         * 使用信号量进行数量控制
         */
        BankWindow window = useBankWindowWithSemaphore();
        if (null!=window) {
            window.check(customer);
            releaseBankWindow();
        }

    }


    public void put(Customer customer) throws InterruptedException {
//        BankWindow window =useBankWindow();
//        window.put(customer);
        BankWindow window = useBankWindowWithSemaphore();
        if (null!=window) {
            window.put(customer);
            releaseBankWindow();
        }
    }

    /**
     * 数量控制，不会丢弃
     * @return
     */
    private synchronized BankWindow useBankWindow(){
        int needSize = windowNum - windows.size();
        if(needSize!=0){
            for(int i=0;i<needSize;i++){
                windows.add(new BankWindow());
            }
        }
        BankWindow bankWindow = windows.poll();
        if(null!=bankWindow){
            return bankWindow;
        }else{
            return useBankWindow();
        }
    }
    /**
     * 数量控制,获取不到则丢弃
     * @return
     */
    private  synchronized BankWindow useBankWindowWithSemaphore() throws InterruptedException {
        BankWindow window = null;
        boolean canUse = semaphore.tryAcquire(1);
        if(canUse){
            window = windows.poll();
        }
        return window;
    }
    private void releaseBankWindow(){
        semaphore.release(1);
        windows.offer(new BankWindow());
    }

    @Getter
    @Setter
    private class BankWindow {

        public void check(Customer customer) throws InterruptedException {
            lock.readLock().lock();
            log.info("查看余额：" + customer.getMoney().getAmount());
            lock.readLock().unlock();

        }

        public void put(Customer customer) throws InterruptedException {
            lock.writeLock().lock();
            customer.getMoney().setAmount(customer.getMoney().getAmount() + 1);
            log.info("存了了一块钱;--------end---------查看余额：" + customer.getMoney().getAmount());
            lock.writeLock().unlock();
        }
    }
}
