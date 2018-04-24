package com.xiaoxin.designpattern.watcher.delegate;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/4/24 下午3:38
 */
@Slf4j
public class WatchCartoonListener {

    

    public void stopPlayingGame(Date date){
        log.info("结束时间"+date);
    }
}
