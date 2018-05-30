package com.xiaoxin.listener.service;

import com.xiaoxin.listener.spring.StockInCompleteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Auther zhangyongxin
 * @date 2018/5/30 下午3:58
 */
@Slf4j
@Service
@Primary
public class StockInServiceImpl implements StockInService, ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void stockIn() {
        log.info("executed method stockIn");
        StockInCompleteEvent event =new StockInCompleteEvent(this,"CGD000001");
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
