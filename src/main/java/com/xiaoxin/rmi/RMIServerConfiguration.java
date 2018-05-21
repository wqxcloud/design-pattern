package com.xiaoxin.rmi;

import com.xiaoxin.rmi.model.Account;
import com.xiaoxin.rmi.service.AccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.rmi.registry.Registry;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午3:25
 */
@Configuration
public class RMIServerConfiguration {

    @Bean("accountServiceRmi")
    public static RmiServiceExporter rmiServiceExporter(@Qualifier("accountService") AccountService accountService){
        RmiServiceExporter serviceExporter = new RmiServiceExporter();
        rmiServiceRegistry(serviceExporter,AccountService.class,accountService,AccountService.class.getSimpleName());
        return  serviceExporter;
    }

    private static void rmiServiceRegistry(RmiServiceExporter rmiServiceExporter,Class serviceClazz, Object service,String serviceName){
        // 不设定时使用默认端口
        rmiServiceExporter.setServicePort(9902);
        // 默认 1099
        rmiServiceExporter.setRegistryPort(9901);
        rmiServiceExporter.setServiceInterface(serviceClazz);
        rmiServiceExporter.setService(service);
        rmiServiceExporter.setServiceName(serviceName);
    }
}
