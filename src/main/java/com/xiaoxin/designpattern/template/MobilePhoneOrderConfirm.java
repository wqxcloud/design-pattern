package com.xiaoxin.designpattern.template;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 手机账号类型的顾客为电商型顾客，需要发送短信通知
 * 订单存储在电商专用数据库，库存信息也是存储在电商专用数据库
 * @Auther zhangyongxin
 * @date 2018/4/16 下午7:25
 */
@Slf4j
public class MobilePhoneOrderConfirm extends OrderConfirm {
    @Override
    public void notifyCustomer(String account) {
        log.info("发送手机通知客户："+account);
    }

    @Override
    public void modifyOrderStatus(String orderId) {
        log.info("调用dubbo接口修改专用数据库的订单信息");
    }

    @Override
    public void freezeVoucherAmount(String voucherId, List<SaleOrderDetail> orderDetails) {
        log.info("调用dubbo接口修改专用数据库的库存信息");
    }
}
