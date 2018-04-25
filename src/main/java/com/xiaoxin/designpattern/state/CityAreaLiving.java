package com.xiaoxin.designpattern.state;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/25 下午10:22
 */
@Slf4j
public class CityAreaLiving extends AreaLiving{
    public CityAreaLiving(Citizen citizen) {
        super(citizen);
    }

    @Override
    public void makeMoney() {
        log.info("城里人挣8000块");
    }

    @Override
    public void liveInHouse() {
        log.info("城里人住公寓楼房，80平");
    }

    @Override
    public void whatLife() {
        if(citizen.getType() == AreaTypeEnum.CITY.getType()){
            super.whatLife();
        }else{
            citizen.setCurrent(new ProvinceAreaLiving(citizen));
            citizen.living();
        }

    }
}
