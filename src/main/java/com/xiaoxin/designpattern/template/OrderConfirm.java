package com.xiaoxin.designpattern.template;

import java.util.List;

/**
 * 订单确认
 * @Auther zhangyongxin
 * @date 2018/4/16 下午7:10
 */
public abstract class OrderConfirm {

    /**
     * 通知客户，发送订单
     * @param account
     */
    public abstract void notifyCustomer(String account);

    /**
     * 修改订单状态
     */
    public abstract void modifyOrderStatus(String orderId);

    /**
     * 冻结库存
     */
    public abstract void freezeVoucherAmount(String voucherId, List<SaleOrderDetail> orderDetails);

    /**
     * 订单确认,固定了订单确认的流程
     */
    public final void confirm(String account,SaleOrder saleOrder){
        notifyCustomer(account);
        modifyOrderStatus(saleOrder.getOrderId());
        freezeVoucherAmount(saleOrder.getVoucherId(),saleOrder.getDetailList());
    }

}
