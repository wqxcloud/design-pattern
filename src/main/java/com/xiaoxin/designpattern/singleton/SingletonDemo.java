package com.xiaoxin.designpattern.singleton;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 下午3:58
 */
public class SingletonDemo {

    private SingletonDemo() {
    }

    private static SingletonDemo singleton;

    public static SingletonDemo getInstance(){
        if(singleton==null){
            singleton = new SingletonDemo();
        }
        return singleton;
    }
}
