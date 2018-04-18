package com.xiaoxin.designpattern.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 墙体
 * @Auther zhangyongxin
 * @date 2018/4/17 下午1:49
 */
@Getter
@Setter
@ToString
public class Wall {
    private double height;
    private double width;

    public Wall(double height, double width) {
        this.height = height;
        this.width = width;
    }
}
