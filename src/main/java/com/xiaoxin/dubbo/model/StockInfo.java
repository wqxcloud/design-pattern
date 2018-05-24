package com.xiaoxin.dubbo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther zhangyongxin
 * @date 2018/5/24 上午10:11
 */
@Getter
@Setter
public class StockInfo implements Serializable {


    private int amount;

    private String skuId;

    private String storeid;
}
