package com.xiaoxin.listener.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;

/**
 * 入库事件
 * @Auther zhangyongxin
 * @date 2018/5/30 下午3:42
 */
@Slf4j
public class StockInCompleteEvent extends ApplicationEvent {

    private String purchasePkId;

    public StockInCompleteEvent(Object source, String purchasePkId) {
        super(source);
        this.purchasePkId=purchasePkId;
    }

    public void changePurchaseOrderStatus(){
        log.info("execute changePurchaseOrderStatus...",purchasePkId);
    }

    public void changePurchaseOrderStatusAnnotationDrived(){
        log.info("execute changePurchaseOrderStatusAnnotationDrived...",purchasePkId);
    }
    public void changePurchaseOrderStatusEventBusDrived(){

        log.info("execute changePurchaseOrderStatusEventBusDrived...",purchasePkId);
    }

}
