package com.xiaoxin.listener.springannotation;

import com.xiaoxin.listener.spring.StockInCompleteEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 使用spring注解方式监听，就不需要实现ApplicationListener接口了
 * @Auther zhangyongxin
 * @date 2018/5/30 下午5:48
 */
@Component
public class StockInCompleteAnnotationNotifier {

    @EventListener
    private void processStockInCompleteEvent(StockInCompleteEvent event){
        event.changePurchaseOrderStatusAnnotationDrived();
    }
}
