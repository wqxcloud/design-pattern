package com.xiaoxin.designpattern.builder;

/**
 * @Auther zhangyongxin
 * @date 2018/4/17 上午11:54
 */
public class HouseBuilderDirector {

    public void build(HouseBuilder houseBuilder){
        houseBuilder.digging();
        houseBuilder.buildWall();
        houseBuilder.buildWindow();
    }
}
