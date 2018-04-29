package com.xiaoxin.designpattern.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 棋盘
 * @Auther zhangyongxin
 * @date 2018/4/29 下午4:44
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Chessboard {

    private int length;

    private int width;
}
