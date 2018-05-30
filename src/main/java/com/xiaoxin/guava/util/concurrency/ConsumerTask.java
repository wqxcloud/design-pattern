package com.xiaoxin.guava.util.concurrency;

import com.xiaoxin.validator.model.ResultGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @Auther zhangyongxin
 * @date 2018/5/30 下午3:04
 */
@Slf4j
public class ConsumerTask implements Callable {
    @Override
    public Object call() {
        log.info("running test in ConsumerTask");
        return ResultGenerator.genSuccessResult();
    }
}
