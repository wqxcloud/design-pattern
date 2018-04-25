package com.xiaoxin.designpattern.state;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther zhangyongxin
 * @date 2018/4/25 下午10:00
 */
public enum AreaTypeEnum {

    COUNTY(1,"县城"),
    CITY(2,"城市"),
    PROVINCE(3,"省份");

    private int type;
    private String desc;

    AreaTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
