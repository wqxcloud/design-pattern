package com.xiaoxin.designpattern.responsibilitychain;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 部长
 * @Auther zhangyongxin
 * @date 2018/4/28 下午5:11
 */
@Slf4j
public class Minister extends Employee{

    public Minister(String name) {
        super(name);
        this.type = "3";
        this.abilities = Arrays.asList(new String[]{"1","2"});
    }

    @Override
    public void handleLeaveRequest(Employee employee) {
        if(abilities.contains(employee.getType())){
            log.info("我是"+name+"，部门主管我处理了"+employee.name+"的请求");

        }
        if(chief!=null){
            chief.handleLeaveRequest(employee);
        }
    }
}
