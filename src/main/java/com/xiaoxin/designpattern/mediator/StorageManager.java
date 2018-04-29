package com.xiaoxin.designpattern.mediator;

import lombok.Getter;
import lombok.Setter;

/**
 * 具体的仓库管理者
 * 负责出库和采购和发货，采购数是出库数 * 2,
 *出库收益是 出库数量 * 10元，采购收益是-采购数量*5元
 * @Auther zhangyongxin
 * @date 2018/4/29 上午11:09
 */
@Getter
@Setter
public class StorageManager extends AbstractStorageManager{

    public StorageManager(StockOutHandler stockOutHandler, PurchaseHandler purchaseHandler) {
        super(stockOutHandler, purchaseHandler);
    }

    @Override
    public void stockOut(int amount) {
        purchaseHandler.amount = stockOutHandler.amount * 2;
        stockOutHandler.money = stockOutHandler.amount * (10-3);
        purchaseHandler.money = purchaseHandler.amount *5;
    }

    @Override
    public void purchase(int amount) {
        purchaseHandler.money =  purchaseHandler.amount *5;
        stockOutHandler.amount = purchaseHandler.amount/2;
        stockOutHandler.money = stockOutHandler.amount * (10-3);
    }


}
