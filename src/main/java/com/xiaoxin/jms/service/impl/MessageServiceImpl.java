package com.xiaoxin.jms.service.impl;

import com.xiaoxin.jms.model.Message;
import com.xiaoxin.jms.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午5:56
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue;
    @Override
    public void addMessage(Message message) {
        log.info("can access to MessageServiceImpl.addMessage");
        jmsTemplate.convertAndSend(queue, message);
    }
}
