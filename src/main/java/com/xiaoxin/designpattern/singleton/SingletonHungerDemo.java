package com.xiaoxin.designpattern.singleton;

/**
 * 饿汉模式
 * @Auther zhangyongxin
 * @date 2018/4/27 下午4:10
 */
public class SingletonHungerDemo {
    private static SingletonHungerDemo singletonHungerDemo = new SingletonHungerDemo();

    private SingletonHungerDemo() {
    }

    public static SingletonHungerDemo newInstance() {
         return singletonHungerDemo;
    }
}
