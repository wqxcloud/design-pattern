package com.xiaoxin.designpattern.command;

import lombok.extern.slf4j.Slf4j;

/**
 * 士兵执行命令
 * @Auther zhangyongxin
 * @date 2018/4/28 下午3:39
 */
@Slf4j
public class Soldier {

    public void execute(String cmd){
        if(this.cancel()){
          return;
        }
        log.info("士兵执行命令："+cmd);
    }

    public boolean cancel(){
        log.info("将在外军令有所不受");
        return true;
    }
}
