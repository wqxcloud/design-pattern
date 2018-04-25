package com.xiaoxin.designpattern.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 邮件通知
 * @Auther zhangyongxin
 * @date 2018/4/25 下午2:40
 */
@Slf4j
public class EmailUserNotifier extends UserNotifier{
    @Override
    public void sendMessage(Message message) {
        log.info("发送邮件："+message);
    }
}
