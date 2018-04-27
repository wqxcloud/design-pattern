package com.xiaoxin.designpattern.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 下午8:01
 */
@Slf4j
public class SilverAxe extends Axe{
    public SilverAxe(String name) {
        super(name);
    }

    @Override
    public void drop() {
        god.pickUp();
        log.info("神圣的主啊！我掉的是："+name);
        god.reward();
        log.info("God bless me");
    }
}
