package com.xiaoxin.designpattern.watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个抽象类，公司活动
 * @Auther zhangyongxin
 * @date 2018/4/23 下午8:09
 */
public  class ActivityManager {
    private List<CompanyActivity> companyActivities = new ArrayList<>();

    /**
     * 报名
     */
    public  void signUp(CompanyActivity companyActivity){
        companyActivities.add(companyActivity);
    }

    /**
     * 退出
     */
    public  void quit(CompanyActivity companyActivity){
        companyActivities.remove(companyActivity);

    }

    public void info(){
        for(CompanyActivity companyActivity : companyActivities){
            companyActivity.start();
        }
    }

}
