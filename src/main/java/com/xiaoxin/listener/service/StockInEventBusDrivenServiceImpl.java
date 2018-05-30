package com.xiaoxin.listener.service;

import com.google.common.eventbus.EventBus;
import com.xiaoxin.listener.guava.StockInCompleteEventBusDrivenListener;
import com.xiaoxin.listener.spring.StockInCompleteEvent;
import org.springframework.stereotype.Service;

/**
 * @Auther zhangyongxin
 * @date 2018/5/30 下午8:48
 */
@Service("stockInEventBusDrivenService")
public class StockInEventBusDrivenServiceImpl implements StockInService{
    @Override
    public void stockIn() {
        EventBus eventBus = new EventBus("StockIn");

        //register all subscriber
        eventBus.register(new StockInCompleteEventBusDrivenListener());
        //publish event
        eventBus.post(new StockInCompleteEvent(this,"CGD000001"));
    }
}
