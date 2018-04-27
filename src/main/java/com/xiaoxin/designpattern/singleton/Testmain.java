package com.xiaoxin.designpattern.singleton;

import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 下午3:59
 */
public class Testmain {
    /**
     * 单例模式：特征：私有的构造函数，static的getInstance方法。也被称之为懒汉模式。
     * 单例模式存在的意义：单例模式能够保证这个实例全局唯一，并且只在需要的时候加载。这样就能够防止大量的实例被创建，是对GC友好的写法。
     * 防止大量的实例被创建，频繁gc造成的性能下降。另外spring bean的默认scope是singleton的。
     */
    @Test
    public void testsingleton(){
        SingletonDemo singletonDemo = SingletonDemo.getInstance();
        SingletonDemo singletonDemo2 = SingletonDemo.getInstance();
        assert singletonDemo.equals(singletonDemo2);

    }
}
