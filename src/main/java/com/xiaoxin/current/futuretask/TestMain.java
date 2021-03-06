package com.xiaoxin.current.futuretask;

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

    @Test
    public void testFutureTask() throws ExecutionException, InterruptedException {

        Money money = new Money();
        Producer producer = new Producer(money);
        Reader reader = new Reader(money);
        FutureTask task1 = new FutureTask(producer);
        FutureTask task3 = new FutureTask(producer);
        FutureTask task2 = new FutureTask(reader);
        ThreadExecutor.execute(task1);
        ThreadExecutor.execute(task2);
        ThreadExecutor.execute(task3);
        for(int i=0;i<1000;i++){
            FutureTask task = new FutureTask(producer);
            ThreadExecutor.execute(task);
        }
        // wait 1/2/3执行完毕
        task1.get();
        task2.get();
        task3.get();
        log.info("我到底还剩多少钱？"+money.getAmount());

    }
}
