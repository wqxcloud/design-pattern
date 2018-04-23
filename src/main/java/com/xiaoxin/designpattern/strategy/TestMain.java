package com.xiaoxin.designpattern.strategy;

/**
 * @Auther zhangyongxin
 * @date 2018/4/23 下午7:24
 */
public class TestMain {
    /**
     * 总结：策略模式其实就是接口的多实现或者类的多继承，就是多态的体现。
     * 缺点：但是具体使用哪种策略需要改造DiscountContext，使之更优雅的选择具体的策略进行封装
     * @param args
     */
    public static void main(String[] args){

        DiscountContext context = new DiscountContext(new TotalReturnDiscount());
        double result = context.getResult(200);
        double result2 = context.getResult(501);
        context = new DiscountContext(new RebateDiscount());
        double result3 = context.getResult(500);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);


    }
}
