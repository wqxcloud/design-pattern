package com.xiaoxin.designpattern.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 房屋对象
 * @Auther zhangyongxin
 * @date 2018/4/17 上午11:34
 */
@Getter
@Setter
@ToString
public class House {

    private String name;
    private Foundation foundation;
    private List<Wall> walls;
    private List<Window> windows;

}
