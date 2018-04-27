package com.xiaoxin.designpattern.state;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Auther zhangyongxin
 * @date 2018/4/25 下午10:47
 */
@Slf4j
public class TestMain {

    /**
     * 总结：状态模式适合 多if-else分支的判断方法进行优化的场景使用。这样可以消除庞大的条件分支语句
     * 当一个对象的行为取决于它的状态，并且它必须在运行时根据状态改变它的行为是，就可以使用状态模式了。
     * 不过需要注意的是，状态逻辑中的条件判断避免写成死循环。
     * testState 方法的效果等价于 testCondition，但是testState更优雅不是吗？
     */
    @Test
    public void testState() throws UnsupportedEncodingException {
        Citizen citizen = new Citizen(AreaTypeEnum.COUNTY.getType());
        citizen.living();
        citizen.setType(AreaTypeEnum.CITY.getType());
        citizen.living();
        citizen.setType(AreaTypeEnum.PROVINCE.getType());
        citizen.living();
        log.info(new String("苏A12345".getBytes(),"GBK"));
    }

    @Test
    public void testCondition(){
        Citizen citizen = new Citizen(AreaTypeEnum.COUNTY.getType());
        living(citizen);
        citizen.setType(AreaTypeEnum.CITY.getType());
        living(citizen);
        citizen.setType(AreaTypeEnum.PROVINCE.getType());
        living(citizen);
    }

    private void living(Citizen citizen) {
        AreaLiving living = new CountyAreaLiving(citizen);
        if (citizen.getType() == AreaTypeEnum.COUNTY.getType()) {
            living = new CountyAreaLiving(citizen);
        } else if (citizen.getType() == AreaTypeEnum.CITY.getType()) {
            living = new CityAreaLiving(citizen);
        } else if (citizen.getType() == AreaTypeEnum.PROVINCE.getType()) {
            living = new ProvinceAreaLiving(citizen);
        }
        living.whatLife();
    }
}
