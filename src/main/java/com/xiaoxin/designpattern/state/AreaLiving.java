package com.xiaoxin.designpattern.state;

/**
 * 不同区域的人住着不同的房子过着不同的生活
 * @Auther zhangyongxin
 * @date 2018/4/25 下午10:06
 */
public abstract class AreaLiving {
    protected Citizen citizen;

    public AreaLiving(Citizen citizen) {
        this.citizen = citizen;
    }

    public abstract void makeMoney();

    public abstract void liveInHouse();

    public void whatLife(){
        makeMoney();
        liveInHouse();
    }
}
