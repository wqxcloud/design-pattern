package com.xiaoxin.designpattern.proxy.cglib;

import com.xiaoxin.designpattern.proxy.PackageThing;
import com.xiaoxin.designpattern.proxy.staticmode.EmployeeExpressReciever;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午5:00
 */
@Slf4j
public class TestMain {
    /**
     *
     * @param args
     */
    public static void main(String[] args){

        /**
         * 代理单独的类
         */
        PackageThing packageThing = new PackageThing(500);
        CaiNiaoStationExpressReciever expressReciever = new CaiNiaoStationExpressReciever();
        CaiNiaoStationExpressReciever proxy = (CaiNiaoStationExpressReciever)new CglibProxy(expressReciever).getProxyInstance();
        proxy.accept(packageThing);
        // proxy: CaiNiaoStationExpressReciever$$EnhancerByCGLIB$$780e6336
        for(Method method : proxy.getClass().getMethods()) {
            log.info(method.getName());
//            equals
//            toString
//            hashCode
//            newInstance
//            newInstance
//            newInstance
//            accept,自动生成的方法
//            setCallback
//            CGLIB$SET_THREAD_CALLBACKS
//            CGLIB$SET_STATIC_CALLBACKS
//            setCallbacks
//            CGLIB$findMethodProxy
//            getCallback
//            getCallbacks
//            wait
//            wait
//            wait
//            getClass
//            notify
//            notifyAll
        }
        /**
         * 代理接口实现类
         */
        EmployeeExpressReciever employeeExpressReciever = new EmployeeExpressReciever();
        EmployeeExpressReciever proxy2 = (EmployeeExpressReciever)new CglibProxy(employeeExpressReciever).getProxyInstance();
        proxy2.accept(packageThing);
    }
}
