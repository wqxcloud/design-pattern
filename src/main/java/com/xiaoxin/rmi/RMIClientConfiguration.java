package com.xiaoxin.rmi;

import com.xiaoxin.rmi.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午4:05
 */
@Configuration
@Lazy
public class RMIClientConfiguration {


    @Bean("clientAccountService")
    public RmiProxyFactoryBean proxyFactoryBean(){
        RmiProxyFactoryBean proxyFactoryBean = new RmiProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("rmi://127.0.0.1:9901/AccountService");
        // 此处一般以jar形式依赖
        // service 和实现需要分model
        proxyFactoryBean.setServiceInterface(AccountService.class);
        proxyFactoryBean.setLookupStubOnStartup(false);
        return proxyFactoryBean;
    }
}
