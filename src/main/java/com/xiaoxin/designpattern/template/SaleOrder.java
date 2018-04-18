package com.xiaoxin.designpattern.template;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午7:16
 */
@Getter
@Setter
public class SaleOrder {
    /**
     * 仓库id
     */
    private String voucherId;

    /**
     * 订单id
     */
    private String orderId;

    private List<SaleOrderDetail> detailList;

    private Customer customer;

}
