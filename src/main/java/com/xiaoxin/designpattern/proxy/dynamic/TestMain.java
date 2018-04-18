package com.xiaoxin.designpattern.proxy.dynamic;

import com.xiaoxin.designpattern.proxy.PackageThing;
import com.xiaoxin.designpattern.proxy.staticmode.EmployeeExpressReciever;
import com.xiaoxin.designpattern.proxy.staticmode.ExpressReciever;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午3:37
 */
@Slf4j
public class TestMain {

    /**
     * 总结：为什么我们这里可以将其转化为ExpressReciever类型的对象？
     * 在newProxyInstance这个方法的第二个参数上，我们给这个代理对象提供了一组什么接口，那么我这个代理对象就会实现了这组接口，
     * 这个时候我们当然可以将这个代理对象强制类型转化为这组接口中的任意一个，因为这里的接口是ExpressReciever类型，
     * 所以就可以将其转化为ExpressReciever类型了。
     * 通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，
     * 也不是我们定义的那组接口的类型，而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。
     * 缺点：只能代理实现了接口的对象，如果想代理一个独立的类就需要cglib
     * @param args
     */
    public static void  main(String[] args){
        PackageThing packageThing = new PackageThing(500);
        EmployeeExpressReciever expressReciever = new EmployeeExpressReciever();
        ExpressReciever proxyFactory = (ExpressReciever)new DynamicProxy(expressReciever).getProxyInstance();
        proxyFactory.accept(packageThing);
        for(Method method : proxyFactory.getClass().getMethods()){
            log.info(method.getName());
//            equals
//            toString
//            hashCode
//            accept,动态生成的方法
//            isProxyClass
//            newProxyInstance
//            getProxyClass
//            getInvocationHandler
//            wait
//            wait
//            wait
//            getClass
//            notify
//            notifyAll
        }

    }
}
