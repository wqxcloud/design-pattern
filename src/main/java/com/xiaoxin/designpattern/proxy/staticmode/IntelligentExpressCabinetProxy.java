package com.xiaoxin.designpattern.proxy.staticmode;

import com.xiaoxin.designpattern.proxy.PackageThing;
import lombok.extern.slf4j.Slf4j;

/**
 * 智能快递柜
 * @Auther zhangyongxin
 * @date 2018/4/16 下午2:45
 */
@Slf4j
public class IntelligentExpressCabinetProxy implements ExpressReciever{
    private ExpressReciever target;

    public void proxy(ExpressReciever target){
        this.target = target;
    }
    @Override
    public void accept(PackageThing packageThing) {
        log.info("智能快递柜accept："+packageThing);
        log.info("智能快递柜发送验证码："+Math.random());
        target.accept(packageThing);
    }
}
