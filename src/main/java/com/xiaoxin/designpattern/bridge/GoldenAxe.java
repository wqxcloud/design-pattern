package com.xiaoxin.designpattern.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 下午8:04
 */
@Slf4j
public class GoldenAxe extends Axe{
    public GoldenAxe(String name) {
        super(name);
    }

    @Override
    public void drop() {
        god.pickUp();
        log.info("我掉的是："+name);
        god.reward();
    }
}
