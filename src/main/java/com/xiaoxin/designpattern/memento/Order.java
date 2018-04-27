package com.xiaoxin.designpattern.memento;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 创建订单类
 * @Auther zhangyongxin
 * @date 2018/4/27 下午2:47
 */
@Getter
@Setter
public class Order {

    private String id;

    private double worth;

    private OrderState state;

    public Order(String id, double worth) {
        this.id = id;
        this.worth = worth;
    }

    public void setState(OrderState kepper) {
        this.id = kepper.getId();
        this.worth = kepper.getWorth();
    }

    public OrderState createState(){
        return new OrderState(id,worth);
    }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", worth=" + worth + '}';
    }
}
