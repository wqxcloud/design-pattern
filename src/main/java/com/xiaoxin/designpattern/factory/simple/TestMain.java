package com.xiaoxin.designpattern.factory.simple;

import com.xiaoxin.designpattern.factory.Message;
import com.xiaoxin.designpattern.factory.UserNotifier;

/**
 * @Auther zhangyongxin
 * @date 2018/4/25 下午2:48
 */
public class TestMain {

    /**
     * 总结：简单工厂维护了消息通知的实现类的获取方式，使用者不需要去创建。但是使用者需要知道每种实现类对应的key,这就相当不友好，
     * 另外如果需要新增加一个实现类的话，还是需要改定factory去增加case，这一点可以用反射来做。
     *
     * @param args
     */
    public static void main(String[] args){
        Message message = new Message("今天下午放学你等着！","有胆你就来","zhangsan@123.com","lisi@123.com");
        try {
            UserNotifier notifier = UsernotifierFactory.getNotifier("email");
            notifier.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
