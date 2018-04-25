package com.xiaoxin.designpattern.state;

import lombok.extern.slf4j.Slf4j;

/**
 * 省会城市的人
 * @Auther zhangyongxin
 * @date 2018/4/25 下午10:27
 */
@Slf4j
public class ProvinceAreaLiving extends AreaLiving{
    public ProvinceAreaLiving(Citizen citizen) {
        super(citizen);
    }

    @Override
    public void makeMoney() {
        log.info("省会城市人挣20000");
    }

    @Override
    public void liveInHouse() {
        log.info("省会城市人住别墅");
    }

    @Override
    public void whatLife() {
        if(citizen.getType() == AreaTypeEnum.PROVINCE.getType()){
            super.whatLife();
        }else{
            citizen.setCurrent(new CountyAreaLiving(citizen));
            citizen.living();
        }
    }
}
