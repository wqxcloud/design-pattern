package com.xiaoxin.listener.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

/**
 * 异步监听
 * 入库完成通知,对应采购单变更状态
 * @Auther zhangyongxin
 * @date 2018/5/30 下午3:39
 */
@Slf4j
@Async
public class StockInCompleteNotifier implements ApplicationListener<StockInCompleteEvent> {

    @Override
    public void onApplicationEvent(StockInCompleteEvent stockInCompleteEvent) {
        stockInCompleteEvent.changePurchaseOrderStatus();
    }
}
