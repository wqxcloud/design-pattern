package com.xiaoxin.designpattern.watcher.delegate;

import com.xiaoxin.designpattern.watcher.ActivityManager;
import com.xiaoxin.designpattern.watcher.ClimbingActivity;
import com.xiaoxin.designpattern.watcher.CompanyActivity;
import com.xiaoxin.designpattern.watcher.SwimingActivity;

import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/4/23 下午8:28
 */
public class TestMain {


    /**
     * 总结：方法委托其实就是通过反射将目标类的目标方法统一调用，达到自由提醒的目的。
     * @param args
     */
    public static void main(String[] args){
        //创建一个尽职尽责的放哨者
        Notifier goodNotifier=new GoodNotifier();

        //创建一个玩游戏的同学，开始玩游戏
        WatchCartoonListener playingGameListener=new WatchCartoonListener();
        //玩游戏的同学告诉放哨的同学，老师来了告诉一下
        goodNotifier.addListener(playingGameListener, "stopPlayingGame",new Date());
        try{
            //一点时间后
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        //老师出现，放哨的人通知所有要帮忙的同学:老师来了
        goodNotifier.notifyX();
    }


}
