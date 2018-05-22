package com.xiaoxin.jms.service;

import com.xiaoxin.jms.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Auther zhangyongxin
 * @date 2018/5/22 下午1:17
 */
@Component
@Slf4j
public class MessageReceiverComponent {

    /**
     *
     * @param message
     */
    @JmsListener(destination = "myMq",containerFactory = "listenerFactory")
    public void receiveMessage(Message message){
        log.info("receive mesage"+message.getContent());
    }

}
