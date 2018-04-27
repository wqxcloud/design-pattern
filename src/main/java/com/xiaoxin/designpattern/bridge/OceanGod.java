package com.xiaoxin.designpattern.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * 海神
 * @Auther zhangyongxin
 * @date 2018/4/27 下午8:09
 */
@Slf4j
public class OceanGod implements God{
    @Override
    public void pickUp() {
        log.info("海神拿出了三个斧子问：我这里有一把金斧头，一把银斧头，还有一把铁斧头，你丢的是哪一个啊？");
    }

    @Override
    public void reward() {
        log.info("海神说：你那么诚实，我就把你丢的还给你吧");
    }
}
