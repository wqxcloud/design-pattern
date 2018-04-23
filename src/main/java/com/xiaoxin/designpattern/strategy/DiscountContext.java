package com.xiaoxin.designpattern.strategy;

/**
 * 打折上下文
 * @Auther zhangyongxin
 * @date 2018/4/23 下午7:22
 */
public class DiscountContext {

    private DiscountComputer discountComputer;

    public DiscountContext(DiscountComputer discountComputer) {
        this.discountComputer = discountComputer;
    }

    public double getResult(double money){
       return discountComputer.checkOut(money);
    }
}
