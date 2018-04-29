package com.xiaoxin.designpattern.responsibilitychain;

import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/29 上午9:08
 */
public class TestMain {

    /**
     *责任链：使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系。
     * 将这个对象连成一个链，并沿着这条链传递该请求，直到有一个对象处理为止。
     * 责任链模式可能会导致性能的下降，如果有更好的解决方式，请使用它们代替它
     */
    @Test
    public void testRespChain(){
        Employee employee = new Engineer("zhangsan");
        Leader leader = new Leader("lisi");
        employee.setChief(leader);
        Minister minister = new Minister("wangwu");
        leader.setChief(minister);
        Boss boss = new Boss("mazi");
        minister.setChief(boss);
        employee.handleLeaveRequest(employee);
        // engineer 是个牛逼的大神直接向老板汇报，辞职也是向老板汇报
        employee.setChief(boss);
        employee.handleLeaveRequest(employee);

    }
}
