//package com.xiaoxin.jms;
//
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Auther zhangyongxin
// * @date 2018/5/21 下午5:36
// */
//@Configuration
//public class ActiveMQConfiguration {
//
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory(){
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
//        activeMQConnectionFactory.setBrokerURL("tcp://127.0.0.1:61616");
//        return activeMQConnectionFactory;
//    }
//
//    @Bean
//    public ActiveMQQueue activeMQQueue(){
//        ActiveMQQueue activeMQQueue = new ActiveMQQueue("myMq");
//        return activeMQQueue;
//    }
//
//}
