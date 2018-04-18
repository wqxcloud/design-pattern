package com.xiaoxin.designpattern.proxy.staticmode;

import com.xiaoxin.designpattern.proxy.PackageThing;
import lombok.extern.slf4j.Slf4j;

/**
 * 上班族需要收件
 * @Auther zhangyongxin
 * @date 2018/4/16 下午2:42
 */
@Slf4j
public class EmployeeExpressReciever implements ExpressReciever{
    @Override
    public void accept(PackageThing packageThing) {
        log.info("accept:"+packageThing);
    }
}
