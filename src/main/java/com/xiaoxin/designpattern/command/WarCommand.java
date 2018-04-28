package com.xiaoxin.designpattern.command;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther zhangyongxin
 * @date 2018/4/28 下午4:25
 */
@Slf4j
public class WarCommand extends Command{
    public WarCommand(Soldier soldier) {
        super(soldier);
    }

    @Override
    public void execute() {
        soldier.execute("炸碉堡");
    }
}
