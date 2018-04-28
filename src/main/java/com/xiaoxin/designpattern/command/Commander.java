package com.xiaoxin.designpattern.command;

/**
 * @Auther zhangyongxin
 * @date 2018/4/28 下午3:48
 */
public class Commander {
    private Command command;

    public Commander(Command command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }

}
