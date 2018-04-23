package com.xiaoxin.designpattern.strategy;

/**
 * 折扣
 * @Auther zhangyongxin
 * @date 2018/4/23 下午7:20
 */
public class RebateDiscount extends DiscountComputer{
    @Override
    public double checkOut(double bills) {
        // 85折
        return bills * 0.85;
    }
}
