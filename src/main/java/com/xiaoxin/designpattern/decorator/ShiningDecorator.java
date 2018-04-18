package com.xiaoxin.designpattern.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 一闪一闪亮晶晶的灯
 * @Auther zhangyongxin
 * @date 2018/4/16 上午11:41
 */
@Slf4j
public class ShiningDecorator extends TreeDecorator{

    @Override
    public void makeWish() {
        super.makeWish();
        log.info("一闪一闪亮晶晶");
    }
}
