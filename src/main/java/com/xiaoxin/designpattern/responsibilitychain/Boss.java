package com.xiaoxin.designpattern.responsibilitychain;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Auther zhangyongxin
 * @date 2018/4/29 上午9:06
 */
@Slf4j
public class Boss extends Employee{
    public Boss(String name) {
        super(name);
        this.type = "4";
        this.abilities = Arrays.asList(new String[]{"1","2","3"});
    }

    @Override
    public void handleLeaveRequest(Employee employee) {
        if(abilities.contains(employee.getType())){
            log.info("我是老板，我可以处理了"+employee.name+"的请求");
        }
    }
}
