package com.xiaoxin.designpattern.mediator;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/29 上午11:20
 */
@Slf4j
public class PurchaseHandler extends AbstractStorageHandler{

    public PurchaseHandler(int amount, int money) {
        super(amount, money);
    }

    public void  purchase() {
        log.info("采购数量："+amount);
        storageManager.purchase(amount);
    }
}
