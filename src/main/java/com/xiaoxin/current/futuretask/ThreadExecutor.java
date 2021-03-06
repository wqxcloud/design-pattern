package com.xiaoxin.current.futuretask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 线程池
 */
@Slf4j
public class ThreadExecutor {
    private static final int POOL_SIZE = 300;
    private static final int MAX_POOL_SIZE = 500;
    private static final int TIME_OUT = 3000;
    private static ThreadPoolExecutor threadPoolExecutor;

    private static ExecutorService getExecutor() {
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            synchronized (ThreadFactory.class) {
                if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                    threadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE,
                    		TIME_OUT, TimeUnit.MILLISECONDS,
                            new LinkedBlockingQueue<Runnable>(100));// 允许等待队列为100个
                    // 解决等待队列满了，避免任务丢失的问题
                    threadPoolExecutor.setRejectedExecutionHandler(new BlockWhenBusyHandler());
                }
            }
        }
        return threadPoolExecutor;
    }

    public static <T extends Runnable> void execute(T thread) {
        getExecutor().execute(thread);
    }

    public static <T> Future<T> submit(Callable<T> task) {
        return getExecutor().submit(task);
    }

}
