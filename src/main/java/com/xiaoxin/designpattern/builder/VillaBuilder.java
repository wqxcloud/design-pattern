package com.xiaoxin.designpattern.builder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 别墅建造者
 * @Auther zhangyongxin
 * @date 2018/4/17 上午11:49
 */
@Slf4j
public class VillaBuilder implements HouseBuilder{
    private House house = new House();

    @Override
    public void digging() {
        log.info("别墅挖地基");
        Foundation foundation = new Foundation(5,10,10);
        house.setFoundation(foundation);
    }

    @Override
    public void buildWall() {
        log.info("别墅修墙");
        Wall wall = new Wall(4,4);
        List<Wall> walls = new ArrayList<>();
        walls.add(wall);
        house.setWalls(walls);

    }

    @Override
    public void buildWindow() {
        log.info("别墅建窗户");
        Window window = new Window(2,2);
        List<Window> windows = new ArrayList<>();
        windows.add(window);
        house.setWindows(windows);
    }


    @Override
    public House genHouse() {
        house.setName("别墅");
        return house;
    }
}
