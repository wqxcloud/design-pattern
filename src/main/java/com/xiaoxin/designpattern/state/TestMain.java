package com.xiaoxin.designpattern.state;

import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/25 下午10:47
 */

public class TestMain {

    /**
     * 总结：状态模式适合 多if-else分支的判断方法进行优化的场景使用。这样可以消除庞大的条件分支语句
     * 当一个对象的行为取决于它的状态，并且它必须在运行时根据状态改变它的行为是，就可以使用状态模式了。
     */
    @Test
    public void test(){
        Citizen citizen = new Citizen(AreaTypeEnum.COUNTY.getType());
        citizen.living();
        citizen.setType(AreaTypeEnum.CITY.getType());
        citizen.living();
        citizen.setType(AreaTypeEnum.PROVINCE.getType());
        citizen.living();
    }
}
