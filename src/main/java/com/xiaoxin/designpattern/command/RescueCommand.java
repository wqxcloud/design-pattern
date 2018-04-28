package com.xiaoxin.designpattern.command;

/**
 * 命令发出者
 * @Auther zhangyongxin
 * @date 2018/4/28 下午3:42
 */
public class RescueCommand extends Command{

    public RescueCommand(String cmd, Soldier soldier) {
        super(cmd, soldier);
    }

    @Override
    public void execute() {
        soldier.execute(cmd);
    }
}
