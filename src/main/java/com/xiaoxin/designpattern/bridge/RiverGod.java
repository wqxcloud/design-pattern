package com.xiaoxin.designpattern.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * 河神
 * @Auther zhangyongxin
 * @date 2018/4/27 下午8:06
 */
@Slf4j
public class RiverGod implements God{
    @Override
    public void pickUp() {
        log.info("河神拿出了三个斧子问：我这里有一把金斧头，一把银斧头，还有一把铁斧头，你丢的是哪一个啊？");
    }

    @Override
    public void reward() {
        log.info("河神说：你那么诚实，我这三把斧子都给你了");
    }
}
