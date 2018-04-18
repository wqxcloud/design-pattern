package com.xiaoxin.designpattern.builder;

/**
 * @Auther zhangyongxin
 * @date 2018/4/17 上午11:50
 */
public interface HouseBuilder {

    /**
     * 挖地基
     *
     */
    void digging();

    /**
     * 修墙
     */
    void buildWall();

    /**
     * 建窗户。。。
     */
    void buildWindow();

    House genHouse();


}
