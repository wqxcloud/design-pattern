package com.xiaoxin.dubbo.config;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.xiaoxin.dubbo.service.StockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfiguration {
    @Bean
    public Dubbo dubbo(){
        return new Dubbo();
    }

    @Bean
    public ApplicationConfig applicationConfig(Dubbo dubbo) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubbo.getApplicationName());
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(Dubbo dubbo) {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubbo.getZookeeperUrl());
        registryConfig.setProtocol("zookeeper");
        registryConfig.setPort(dubbo.getPort());
        registryConfig.setGroup(dubbo.getGroup());
        return registryConfig;
    }
    @Bean
    public ProtocolConfig protocol(Dubbo dubbo) {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(dubbo.getPort());
        protocolConfig.setSerialization(dubbo.getSerialization());
        return protocolConfig;
    }


    @Bean
    public ProviderConfig provider(Dubbo dubbo) {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(dubbo.getTimeOut());
        providerConfig.setOwner(dubbo.getOwner());
        providerConfig.setGroup(dubbo.getGroup());
        return providerConfig;
    }

    @Bean
    public ConsumerConfig consumer(Dubbo dubbo) {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(dubbo.getTimeOut());
        consumerConfig.setOwner(dubbo.getOwner());
        consumerConfig.setGroup(dubbo.getGroup());
        return consumerConfig;
    }

    @Bean
    public ServiceBean<StockService> stockService(RegistryConfig registryConfig, ApplicationConfig applicationConfig, ProviderConfig providerConfig,
                                                  ProtocolConfig protocolConfig,Dubbo dubbo,StockService stockService) {
        ServiceBean<StockService> ref = registerService(registryConfig, applicationConfig, providerConfig,protocolConfig, dubbo,StockService.class, stockService);
        return ref;
    }

    /**
     * consumer
     * @param registryConfig
     * @param applicationConfig
     * @param consumerConfig
     * @param dubbo
     * @param interfaceClazz
     * @param <T>
     * @return
     */
    protected <T> ReferenceBean<T> registerReference(RegistryConfig registryConfig, ApplicationConfig applicationConfig, ConsumerConfig consumerConfig, Dubbo dubbo, Class<T> interfaceClazz) {
        ReferenceBean<T> ref = new ReferenceBean<>();
        ref.setInterface(interfaceClazz);
        ref.setRegistry(registryConfig);
        ref.setApplication(applicationConfig);
        ref.setConsumer(consumerConfig);
        ref.setGroup(dubbo.getGroup());
        ref.setCheck(dubbo.isCheckOnStartup());
        return ref;
    }

    /**
     * provider
     * @param registryConfig
     * @param applicationConfig
     * @param providerConfig
     * @param protocolConfig
     * @param dubbo
     * @param interfaceClazz
     * @param t
     * @param <T>
     * @return
     */
    protected <T> ServiceBean<T> registerService(RegistryConfig registryConfig, ApplicationConfig applicationConfig, ProviderConfig providerConfig, ProtocolConfig protocolConfig, Dubbo dubbo, Class<T> interfaceClazz, T t) {
        ServiceBean<T> ref = new ServiceBean<>();
        ref.setInterface(interfaceClazz);
        ref.setRegistry(registryConfig);
        ref.setApplication(applicationConfig);
        ref.setProvider(providerConfig);
        ref.setRef(t);
        ref.setProtocol(protocolConfig);
        ref.setGroup(dubbo.getGroup());
        return ref;
    }
}