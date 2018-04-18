package com.xiaoxin.designpattern.proxy.dynamic;

import com.xiaoxin.designpattern.proxy.PackageThing;
import com.xiaoxin.designpattern.proxy.staticmode.EmployeeExpressReciever;
import com.xiaoxin.designpattern.proxy.staticmode.ExpressReciever;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午3:31
 */
@Slf4j
public class DynamicProxy {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance( target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                        log.info("代理工厂开始准备:proxy instanceof ExpressReciever ?"+(proxy instanceof ExpressReciever));
                        log.info("代理工厂args instanceof PackageThing："+(args[0] instanceof PackageThing));
                        log.info("代理工厂发送短信：0000");
                        Object returnValue = method.invoke(target, args);
                        return returnValue;
                });
    }
}
