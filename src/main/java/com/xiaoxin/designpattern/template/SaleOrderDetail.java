package com.xiaoxin.designpattern.template;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午7:20
 */
@Getter
@Setter
public class SaleOrderDetail {
    private int amount;

    private Double cost;

    private String skuId;

    private String orderId;
}
