package com.xiaoxin.designpattern.template;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * email类型的账号一般为web用户，订单从线下专用的库存走
 * @Auther zhangyongxin
 * @date 2018/4/16 下午7:30
 */
@Slf4j
public class EmailOrderConfirm extends OrderConfirm {
    @Override
    public void notifyCustomer(String account) {
        log.info("email 通知客户");
    }

    @Override
    public void modifyOrderStatus(String orderId) {
        log.info("修改线下专用库，订单信息");
    }

    @Override
    public void freezeVoucherAmount(String voucherId, List<SaleOrderDetail> orderDetails) {
        log.info("修改线下专用库，库存信息");
    }

}
