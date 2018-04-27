package com.xiaoxin.designpattern.singleton;

/**
 * 懒汉模式
 * @Auther zhangyongxin
 * @date 2018/4/27 下午3:58
 */
public class SingletonLazyDemo {

    private SingletonLazyDemo() {
    }

    private static SingletonLazyDemo singleton;

    public static SingletonLazyDemo getInstance(){
        if(singleton==null){
            singleton = new SingletonLazyDemo();
        }
        return singleton;
    }
}
