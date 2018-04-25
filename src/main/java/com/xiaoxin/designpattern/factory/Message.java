package com.xiaoxin.designpattern.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 消息对象
 * @Auther zhangyongxin
 * @date 2018/4/25 下午2:39
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Message {

    private String subject;

    private String body;

    private String toWhom;

    private String fromWhom;
}
