package com.xiaoxin.designpattern.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 窗户
 * @Auther zhangyongxin
 * @date 2018/4/17 下午1:51
 */
@Getter
@Setter
@ToString
public class Window {
    private double height;
    private double width;

    public Window(double height, double width) {
        this.height = height;
        this.width = width;
    }
}
