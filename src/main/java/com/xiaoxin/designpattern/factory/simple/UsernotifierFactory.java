package com.xiaoxin.designpattern.factory.simple;

import com.xiaoxin.designpattern.factory.EmailUserNotifier;
import com.xiaoxin.designpattern.factory.ShortMsgUserNotifier;
import com.xiaoxin.designpattern.factory.UserNotifier;

/**
 * 工厂方法
 * @Auther zhangyongxin
 * @date 2018/4/25 下午2:44
 */
public class UsernotifierFactory {

    public static UserNotifier getNotifier(String type) throws Exception {
        switch (type){
            case "email":
                return new EmailUserNotifier();
            case "shortMsg":
                return new ShortMsgUserNotifier();
                default:
                    throw new Exception("no such notifier ");
        }
    }
}
