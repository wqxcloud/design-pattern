package com.xiaoxin.designpattern.watcher;

/**
 * @Auther zhangyongxin
 * @date 2018/4/23 下午8:28
 */
public class TestMain {

    /**
     *总结：观察者模式其实就是订阅模式，观察者模式定义了一种一对多的依赖关系，让多个观察者对象能够同时监听某个主体的对象。
     * 这个主体在状态变化时，会通知所有观察者对象，使他们能够更新自己
     * 缺点：可以看出每个观察者对象的更新方法是一样的，如果每个观察者对象需要触发不同的方法进行更新，这个时候就需要结合方法委托进行改造了。
     * @param args
     */
    public static void main(String[] args){
        ActivityManager activityManager = new ActivityManager();
        CompanyActivity companyActivity = new ClimbingActivity(30);
        CompanyActivity swimingActivity = new SwimingActivity(10);
        activityManager.signUp(companyActivity);
        activityManager.signUp(swimingActivity);
        activityManager.info();
    }


}
