package com.xiaoxin.designpattern.state;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/25 下午10:21
 */
@Slf4j
public class CountyAreaLiving extends AreaLiving{

    public CountyAreaLiving(Citizen citizen) {
        super(citizen);
    }

    @Override
    public void makeMoney() {
        log.info("县城人挣2000块");
    }

    @Override
    public void liveInHouse() {
        log.info("县城人住砖瓦平方，200平");
    }

    @Override
    public void whatLife() {

        if(citizen.getType() == AreaTypeEnum.COUNTY.getType()){
            super.whatLife();
        }else{
            citizen.setCurrent(new CityAreaLiving(citizen));
            citizen.living();
        }
    }
}
