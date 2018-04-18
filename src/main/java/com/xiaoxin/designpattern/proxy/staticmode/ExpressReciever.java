package com.xiaoxin.designpattern.proxy.staticmode;

import com.xiaoxin.designpattern.proxy.PackageThing;

/**
 * 快递接收者
 * @Auther zhangyongxin
 * @date 2018/4/16 下午2:31
 */
public interface ExpressReciever {

    void accept(PackageThing packageThing);

}
