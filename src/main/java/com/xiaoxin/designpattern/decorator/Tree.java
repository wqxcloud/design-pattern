package com.xiaoxin.designpattern.decorator;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户可以将树装饰为圣诞树，或者中国的许愿树
 * @Auther zhangyongxin
 * @date 2018/4/16 上午11:30
 */
@Getter
@Setter
@Slf4j
public  class Tree {
    private String name;

    public Tree(String name) {
        this.name = name;
    }

    public Tree() {
    }

    public void makeWish(){
        log.info("name："+name);
    }

}
