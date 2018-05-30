package com.xiaoxin.listener.guava;

import com.google.common.eventbus.Subscribe;
import com.xiaoxin.listener.spring.StockInCompleteEvent;

/**
 * @Auther zhangyongxin
 * @date 2018/5/30 下午8:39
 */
public class StockInCompleteEventBusDrivenListener {

    @Subscribe
    public void changePurchaseOrderStatusEventBusDriven(StockInCompleteEvent event) {
        event.changePurchaseOrderStatusEventBusDrived();
    }
}
