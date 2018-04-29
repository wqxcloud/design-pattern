package com.xiaoxin.designpattern.mediator;

import lombok.extern.slf4j.Slf4j;

/**
 *运费是数量 * 2元
 * @Auther zhangyongxin
 * @date 2018/4/29 上午11:20
 */
@Slf4j
public class StockOutHandler extends AbstractStorageHandler{
    public StockOutHandler(int amount, int money) {
        super(amount, money);
    }

    public void  stockOut() {
        log.info("出库数量："+amount);
        storageManager.stockOut(amount);
    }
}
