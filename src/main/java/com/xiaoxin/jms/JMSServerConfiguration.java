//package com.xiaoxin.jms;
//
//import com.xiaoxin.jms.service.MessageService;
//import com.xiaoxin.jms.service.impl.MessageServiceImpl;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.listener.SimpleMessageListenerContainer;
//import org.springframework.jms.remoting.JmsInvokerServiceExporter;
//
///**
// * @Auther zhangyongxin
// * @date 2018/5/21 下午5:49
// */
//@Configuration
//public class JMSServerConfiguration {
//
//    @Bean("serviceMessageService")
//    public JmsInvokerServiceExporter jmsInvokerServiceExporter() {
//        JmsInvokerServiceExporter jmsInvokerServiceExporter = new JmsInvokerServiceExporter();
//        jmsInvokerServiceExporter.setService(MessageServiceImpl.class);
//        jmsInvokerServiceExporter.setServiceInterface(MessageService.class);
//        return jmsInvokerServiceExporter;
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer(ActiveMQConnectionFactory activeMQConnectionFactory,
//                                                                         ActiveMQQueue activeMQQueue,
//                                                                         @Qualifier("serviceMessageService") JmsInvokerServiceExporter jmsInvokerServiceExporter){
//        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//        simpleMessageListenerContainer.setConnectionFactory(activeMQConnectionFactory);
//        simpleMessageListenerContainer.setDestination(activeMQQueue);
//        simpleMessageListenerContainer.setConcurrentConsumers(10);
//        simpleMessageListenerContainer.setMessageListener(jmsInvokerServiceExporter);
//        return simpleMessageListenerContainer;
//    }
//}
