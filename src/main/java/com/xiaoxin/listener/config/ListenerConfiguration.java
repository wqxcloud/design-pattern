package com.xiaoxin.listener.config;

import com.xiaoxin.listener.spring.StockInCompleteListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 配置支持异步事件
 * @Auther zhangyongxin
 * @date 2018/5/30 下午4:20
 */
@Configuration
@Slf4j
public class ListenerConfiguration implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(10);
        // 最大线程数
        executor.setMaxPoolSize(50);
        // 队列最大长度
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("ListenerExecutor-");
        // 线程池维护线程所允许的空闲时间 5分钟
        executor.setKeepAliveSeconds(300);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
                log.error("执行异步线程异常",throwable);
            }
        };
    }

    @Bean
    public StockInCompleteListener stockInCompleteNotifier(){
        return new StockInCompleteListener();
    }
}
