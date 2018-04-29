package com.xiaoxin.designpattern.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 棋子
 * @Auther zhangyongxin
 * @date 2018/4/29 下午4:41
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Chesspiece {
    // 车马相士将炮兵
    private String name;
    // 属于红方还是黑方
    private String belongTo;
}
