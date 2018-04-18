package com.xiaoxin.designpattern.proxy.cglib;

import com.xiaoxin.designpattern.proxy.PackageThing;
import com.xiaoxin.designpattern.proxy.staticmode.ExpressReciever;
import lombok.extern.slf4j.Slf4j;

/**
 * 菜鸟驿站接收
 * @Auther zhangyongxin
 * @date 2018/4/16 下午2:42
 */
@Slf4j
public class CaiNiaoStationExpressReciever {
    public void accept(PackageThing packageThing) {
        log.info("accept:"+packageThing);
    }
}
