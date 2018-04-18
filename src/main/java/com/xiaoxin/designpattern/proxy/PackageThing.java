package com.xiaoxin.designpattern.proxy;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午2:36
 */
@Getter
@Setter
public class PackageThing {
    private double worth;

    public PackageThing(double worth) {
        this.worth = worth;
    }

    @Override
    public String toString() {
        return "PackageThing{" + "worth=" + worth + '}';
    }
}
