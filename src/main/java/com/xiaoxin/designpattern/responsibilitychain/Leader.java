package com.xiaoxin.designpattern.responsibilitychain;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Auther zhangyongxin
 * @date 2018/4/28 下午5:00
 */
@Slf4j
public class Leader extends Employee{

    public Leader(String name) {
        super(name);
        this.type = "2";
        this.abilities = Arrays.asList(new String[]{"1"});
    }

    @Override
    public void handleLeaveRequest(Employee employee) {
        if(abilities.contains(employee.getType())){
            log.info("我是"+name+"小组长，我可以处理我"+employee.name+"的请求,并且需要上级审批");

        }
        if(chief!=null){
            chief.handleLeaveRequest(employee);
        }
    }
}
