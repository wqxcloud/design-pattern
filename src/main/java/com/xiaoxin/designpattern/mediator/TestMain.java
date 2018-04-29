package com.xiaoxin.designpattern.mediator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/29 上午11:46
 */
@Slf4j
public class TestMain {

    /**
     * 中介者模式：又叫调停者模式，它能够避免两个相类似的colleague(同事)类相互耦合，
     * 但是调停者在此的作用就相当重要了，所以这个模式需要慎重，另外随着colleague的增多，
     * 充当调停者的那个类就会越来越庞大，也越来越难维护。所以中介者模式慎用。
     */
    @Test
    public void testMediator(){
        StockOutHandler stockOutHandler = new StockOutHandler(20,0);
        PurchaseHandler purchaseHandler = new PurchaseHandler(0,0);
        StorageManager storageManager = new StorageManager(stockOutHandler,purchaseHandler);
        stockOutHandler.setStorageManager(storageManager);
        stockOutHandler.stockOut();
        log.info("本次出库净利润：" +stockOutHandler.money);
        log.info("本次出库数量：" +stockOutHandler.amount);
        log.info("本次需要采购数量：" +purchaseHandler.amount);
        log.info("本次采购需要花费：" +purchaseHandler.money);


    }
}
