package com.xiaoxin.designpattern.responsibilitychain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工对象
 * 以离职为例，employee -> leader -> minister -> boss
 * 层层审批
 * @Auther zhangyongxin
 * @date 2018/4/28 下午4:51
 */
public abstract class Employee {


    protected String name;

    protected String type = "1";

    protected List abilities=new ArrayList();

    public Employee(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    /**
     * 向上报告
     */
    protected Employee chief;

    public void setChief(Employee chief) {
        this.chief = chief;
    }

    public abstract void handleLeaveRequest(Employee employee);
}
