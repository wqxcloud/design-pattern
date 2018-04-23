package com.xiaoxin.designpattern.strategy;

/**
 * 满减打折计算
 * @Auther zhangyongxin
 * @date 2018/4/23 下午7:18
 */
public class TotalReturnDiscount extends DiscountComputer{
    @Override
    public double checkOut(double bills) {
        // 满500减100
        if(bills >= 500){
            bills = bills - 100;
        }
        return bills;
    }
}
