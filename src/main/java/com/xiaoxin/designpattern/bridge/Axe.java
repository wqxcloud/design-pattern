package com.xiaoxin.designpattern.bridge;

import lombok.Getter;
import lombok.Setter;

/**
 *定义斧子对象
 * @Auther zhangyongxin
 * @date 2018/4/27 下午7:58
 */
@Getter
@Setter
public abstract class Axe {

    protected God god;

    protected String name;

    public Axe(String name) {
        this.name = name;
    }

    /**
     * 定义斧子掉进河里事件
     */
    public abstract void drop();
}
