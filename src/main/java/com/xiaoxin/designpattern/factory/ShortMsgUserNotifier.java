package com.xiaoxin.designpattern.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/25 下午2:42
 */
@Slf4j
public class ShortMsgUserNotifier extends UserNotifier{
    @Override
    public void sendMessage(Message message) {
        log.info("发送短信："+message);
    }
}
