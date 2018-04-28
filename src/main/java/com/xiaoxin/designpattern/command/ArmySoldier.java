package com.xiaoxin.designpattern.command;

import lombok.extern.slf4j.Slf4j;

/**
 * 陆军战士
 * @Auther zhangyongxin
 * @date 2018/4/28 下午4:27
 */
@Slf4j
public class ArmySoldier extends Soldier{
    public ArmySoldier() {
    }

    @Override
    public void execute(String cmd) {
        log.info("执行命令："+cmd);
    }
}
