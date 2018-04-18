package com.xiaoxin.designpattern.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 上午11:53
 */
@Slf4j
public class WishPaperDecorator extends TreeDecorator{
    @Override
    public void makeWish() {
        super.makeWish();
        log.info("早生贵子");
    }
}
