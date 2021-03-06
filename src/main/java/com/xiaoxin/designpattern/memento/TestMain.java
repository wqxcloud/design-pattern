package com.xiaoxin.designpattern.memento;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 下午2:58
 */
@Slf4j
public class TestMain {

    /**
     * 备忘录模式：例如：java的赋值是引用传递，所以一旦修改了赋值后的对象的属性值，原对象的属性值也是跟着变化的。
     * 这时备忘录模式的存在价值就可以体现了。他可以存储和保留想要保留的对象的状态，以备后面可以随时恢复。
     * 其实在Java里面可以使用类拷贝进行处理这类问题。但是备忘录模式稍微委婉点。
     * 备忘录模式的状态可以看做一个个的检查点。还有许多的变种：例如多检查点模式等。
     */
    @Test
    public void testMemento(){
        Order order = new Order("1",20.0);
        log.info(order.toString());

        OrderStateKepper kepper = new OrderStateKepper();
        kepper.setState(order.createState());

        order.setId("2");
        order.setWorth(30.0);
        log.info(order.toString());

        order.setState(kepper.getState());
        log.info(order.toString());
    }
}
