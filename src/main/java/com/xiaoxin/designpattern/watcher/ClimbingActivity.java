package com.xiaoxin.designpattern.watcher;

import lombok.extern.slf4j.Slf4j;

/**
 * 爬山
 * @Auther zhangyongxin
 * @date 2018/4/23 下午8:23
 */
@Slf4j
public class ClimbingActivity extends CompanyActivity{
    public ClimbingActivity (int members) {
        super(members);
    }

    @Override
    public void start() {
        log.info("登山活动开始");
    }

}
