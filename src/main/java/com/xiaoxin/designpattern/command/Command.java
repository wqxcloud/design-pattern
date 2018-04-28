package com.xiaoxin.designpattern.command;

import lombok.Getter;
import lombok.Setter;

/**
 * 抽象的命令
 * @Auther zhangyongxin
 * @date 2018/4/28 下午3:38
 */
@Setter
@Getter
public abstract class Command {

    protected Soldier soldier;

    public Command(Soldier soldier) {
        this.soldier = soldier;
    }
    public abstract void execute();
}
