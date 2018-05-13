package com.xiaoxin.current.futuretask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther zhangyongxin
 * @date 2018/5/13 上午10:50
 */
@Slf4j
public class BlockWhenBusyHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                log.error("error", e);
            }
        }
    }
}
