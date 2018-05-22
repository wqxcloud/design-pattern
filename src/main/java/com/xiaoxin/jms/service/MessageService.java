package com.xiaoxin.jms.service;

import com.xiaoxin.jms.model.Message;

import javax.jms.Queue;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午5:56
 */
public interface MessageService {

    void addMessage(Message message);
}
