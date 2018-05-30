package com.xiaoxin.guava.util.consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

/**
 * @Auther zhangyongxin
 * @date 2018/5/30 上午11:25
 */
@Slf4j
public class BiPrinterConsumer implements BiConsumer {
    @Override
    public void accept(Object o, Object o2) {
        log.info("accepted key:{},value:{}",o,o2);
    }
}
