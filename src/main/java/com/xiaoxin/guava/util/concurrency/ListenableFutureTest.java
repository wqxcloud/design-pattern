package com.xiaoxin.guava.util.concurrency;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.xiaoxin.current.futuretask.ThreadExecutor;
import com.xiaoxin.validator.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Auther zhangyongxin
 * @date 2018/5/30 下午3:03
 */
@Slf4j
public class ListenableFutureTest {

    @Test
    public void listenableFutureTest(){
        FutureTask future = ListenableFutureTask.create(new ConsumerTask());
        try {
            ThreadExecutor.execute(future);
            log.info("thread returns {}",future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
