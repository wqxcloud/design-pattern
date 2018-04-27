package com.xiaoxin.designpattern.bridge;

import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 下午8:10
 */
public class TestMain {
    /**
     * 桥接模式：实现系统可能有多角度分类，每个分类都有可能变化，那么就把这种多角度分离出来让它们独立变化，减少它们之间的耦合。
     * 一句话总结就是：将抽象部分与它的实现部分分离，使它们都可以独立发生变化。
     */
    @Test
    public void testBridge(){
        Axe silverAxe = new SilverAxe("银斧子");
        silverAxe.setGod(new RiverGod());
        silverAxe.drop();
        silverAxe.setGod(new OceanGod());
        silverAxe.drop();

        Axe godenAxe = new GoldenAxe("金斧子");
        godenAxe.setGod(new RiverGod());
        godenAxe.drop();
    }
}
