package com.xiaoxin.designpattern.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午4:56
 */
@Slf4j
public class CglibProxy implements MethodInterceptor{

    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("cglib : 扫码了");
        log.info("cglib : 入库了");
        log.info("cglib : 出库了");
        return method.invoke(target,args);
    }
}
