package com.xiaoxin.designpattern.command;

import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/28 下午3:44
 */
public class TestMain {

    /**
     * 命令模式：本例中Commander为长官，是发号施令的人，RescueCommand为具体的命令，Soldier为士兵，具体的命令执行者
     * 这样，命令，命令发出者，命令执行者就互相解耦。
     * 命令模式就是将一个请求封装为一个对象，从而是你可用不同的请求对客户进行参数话，对请求排队或记录请求日志，以及支持可撤销的操作。
     */
    @Test
    public void testCommand(){
        Soldier soldier = new Soldier();
        Command command = new RescueCommand(soldier);
        Commander commander = new Commander(command);
        commander.execute();

        ArmySoldier armySoldier = new ArmySoldier();
        Command warCommand = new WarCommand(armySoldier);
        Commander warCommander = new Commander(warCommand);
        warCommander.execute();

    }
}
