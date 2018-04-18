package com.xiaoxin.designpattern.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/17 下午1:46
 */
@Slf4j
public class TestMain {

    /**
     * 总结：建造者模式是在当创建复杂对象的算法应当独立于该对象的组成部分，以及它的装配方式时使用的模式
     * 这里具体建造什么，怎么建造需要实现HouseBuilder接口
     * 装配是固定流程，则在HouseBuilderDirector同一定义了。
     * @param args
     */
    public static void main(String[] args){
        VillaBuilder villaBuilder = new VillaBuilder();
        House house = villaBuilder.genHouse();
        HouseBuilderDirector director = new HouseBuilderDirector();
        director.build(villaBuilder);
        log.info(house.toString());
    }
}
