package com.xiaoxin.jms.config;

import com.xiaoxin.jms.DefaultResponseQueueListener;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

/**
 * @Auther zhangyongxin
 * @date 2018/5/22 下午1:31
 */
@Configuration
@Lazy
public class ActiveMqConfiguration {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("myMq");
    }

    /**
     * Serialize message content to json using TextMessage
     * 否则需要配置信任的package
     *
     * @return
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public JmsListenerContainerFactory<?> listenerFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    public DefaultResponseQueueListener defaultResponseQueueListener() {
        DefaultResponseQueueListener listener = new DefaultResponseQueueListener();
        return listener;
    }


}
