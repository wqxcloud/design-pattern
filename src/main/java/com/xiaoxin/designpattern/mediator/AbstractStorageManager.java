package com.xiaoxin.designpattern.mediator;

/**
 * 抽象的仓储管理者
 * @Auther zhangyongxin
 * @date 2018/4/29 上午11:05
 */
public abstract class AbstractStorageManager {

    protected StockOutHandler stockOutHandler;

    protected PurchaseHandler purchaseHandler;

    public AbstractStorageManager(StockOutHandler stockOutHandler, PurchaseHandler purchaseHandler) {
        this.stockOutHandler = stockOutHandler;
        this.purchaseHandler = purchaseHandler;
    }

    /**
     * 出库
     * @param amount
     */
    public abstract void stockOut(int amount);


    /**
     * 采购
     * @param amount
     */
    public abstract void purchase(int amount);


}
