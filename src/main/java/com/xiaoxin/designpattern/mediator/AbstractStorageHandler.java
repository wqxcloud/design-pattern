package com.xiaoxin.designpattern.mediator;

import lombok.AllArgsConstructor;

/**
 * 抽象的库存操控着
 * @Auther zhangyongxin
 * @date 2018/4/29 上午11:18
 */
public abstract class AbstractStorageHandler {

    protected int amount;

    protected int money;

    protected StorageManager storageManager;

    public AbstractStorageHandler(int amount, int money) {
        this.amount = amount;
        this.money = money;
    }

    public StorageManager getStorageManager() {
        return storageManager;
    }

    public void setStorageManager(StorageManager storageManager) {
        this.storageManager = storageManager;
    }
}
