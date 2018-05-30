package com.xiaoxin.guava.util.consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

/**
 * @Auther zhangyongxin
 * @date 2018/5/29 上午10:28
 */
@Slf4j
public class ObjectPrintConsumer implements Consumer {
    @Override
    public void accept(Object o) {
        log.info("accepted element:{}",o);
    }
}
