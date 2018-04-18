package com.xiaoxin.designpattern.proxy.staticmode;

import com.xiaoxin.designpattern.proxy.PackageThing;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午3:05
 */
public class TestMain {
    /**
     * 总结：静态代理就是对即存功能的再次封装，而不改变原有功能的逻辑
     * 缺点：静态代理的对象很有限，缺乏灵活性
     * @param args
     */
    public static void main(String[] args){
        PackageThing packageThing = new PackageThing(500);
        EmployeeExpressReciever employeeExpressReciever = new EmployeeExpressReciever();
        IntelligentExpressCabinetProxy expressCabinetProxy = new IntelligentExpressCabinetProxy();
        expressCabinetProxy.proxy(employeeExpressReciever);
        expressCabinetProxy.accept(packageThing);
    }
}
