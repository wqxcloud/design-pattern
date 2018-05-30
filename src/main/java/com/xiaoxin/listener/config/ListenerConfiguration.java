package com.xiaoxin.listener.config;

import com.xiaoxin.listener.spring.StockInCompleteNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Auther zhangyongxin
 * @date 2018/5/30 下午4:20
 */
@Configuration
public class ListenerConfiguration {
    @Bean
    public StockInCompleteNotifier stockInCompleteNotifier(){
        return new StockInCompleteNotifier();
    }
}
