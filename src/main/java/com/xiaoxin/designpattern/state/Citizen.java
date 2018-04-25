package com.xiaoxin.designpattern.state;

import com.sun.javafx.geom.Area;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther zhangyongxin
 * @date 2018/4/25 下午10:23
 */
@Getter
@Setter
public class Citizen {
    private int type;

    private AreaLiving current;

    public Citizen(int type) {
        this.type = type;
        current = new CountyAreaLiving(this);
    }

    public void living(){
        current.whatLife();
    }
}
