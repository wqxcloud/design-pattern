package com.xiaoxin.designpattern.singleton;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 下午4:21
 */
public class SingletonLazySafeDemo {
    private static SingletonLazySafeDemo singletonLazySafeDemo;

    private SingletonLazySafeDemo() {
    }


    /**
     * 仍然不安全，因为仍然能进if
     */
//    public static SingletonLazySafeDemo newInstance(){
//        if(null == singletonLazySafeDemo){
//            synchronized (SingletonLazySafeDemo.class){
//                singletonLazySafeDemo = new SingletonLazySafeDemo();
//            }
//        }
//        return singletonLazySafeDemo;
//    }

    /**
     * 线程安全，但是要是以最细粒度的加锁原则的话，还是不太理想
     * @return
     */
//    public static synchronized SingletonLazySafeDemo newInstance(){
//        if(null == singletonLazySafeDemo){
//                singletonLazySafeDemo = new SingletonLazySafeDemo();
//        }
//        return singletonLazySafeDemo;
//    }

    /**
     * 双重检验，网上有人说也不能保证线程安全，但是我的测试发现线程是安全的
     * @return
     */
//    public static SingletonLazySafeDemo newInstance(){
//        if(null == singletonLazySafeDemo){
//            synchronized (SingletonLazySafeDemo.class){
//                if(null == singletonLazySafeDemo) {
//                    singletonLazySafeDemo = new SingletonLazySafeDemo();
//                }
//            }
//        }
//        return singletonLazySafeDemo;
//    }

    private static class SingletonHolder{
        private static SingletonLazySafeDemo instance = new SingletonLazySafeDemo();
    }

    /**
     * 结合了懒汉模式和饿汉模式优点
     * @return
     */
    public static SingletonLazySafeDemo newInstance(){
        return SingletonHolder.instance;
    }
}
