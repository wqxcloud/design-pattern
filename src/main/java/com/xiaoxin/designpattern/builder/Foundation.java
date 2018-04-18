package com.xiaoxin.designpattern.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 根基
 * @Auther zhangyongxin
 * @date 2018/4/17 下午1:48
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Foundation {
    private double depth;
    private double length;
    private double width;
}
