package com.xiaoxin.designpattern.responsibilitychain;

/**
 * @Auther zhangyongxin
 * @date 2018/4/29 上午9:36
 */
public class Engineer extends Employee{
    public Engineer(String name) {
        super(name);
        this.type ="1";
    }

    @Override
    public void handleLeaveRequest(Employee employee) {
        if(chief!=null){
            chief.handleLeaveRequest(employee);
        }
    }
}
