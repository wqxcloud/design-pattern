//package com.xiaoxin.jms;
//
//import com.xiaoxin.jms.service.MessageService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.remoting.JmsInvokerProxyFactoryBean;
//
///**
// * @Auther zhangyongxin
// * @date 2018/5/21 下午7:27
// */
//@Slf4j
//@Configuration
//public class JMSClientConfiguration {
//
//    @Bean("clientMessageService")
//    public JmsInvokerProxyFactoryBean jmsInvokerProxyFactoryBean(ActiveMQConnectionFactory activeMQConnectionFactory, ActiveMQQueue activeMQQueue) {
//        JmsInvokerProxyFactoryBean jmsInvokerProxyFactoryBean = new JmsInvokerProxyFactoryBean();
//        jmsInvokerProxyFactoryBean.setServiceInterface(MessageService.class);
//        jmsInvokerProxyFactoryBean.setConnectionFactory(activeMQConnectionFactory);
//        jmsInvokerProxyFactoryBean.setQueue(activeMQQueue);
//        return jmsInvokerProxyFactoryBean;
//    }
//}
