package com.xiaoxin.designpattern.watcher;

import lombok.extern.slf4j.Slf4j;

/**
 * 游泳
 * @Auther zhangyongxin
 * @date 2018/4/23 下午8:23
 */
@Slf4j
public class SwimingActivity extends CompanyActivity {
    public SwimingActivity(int members) {
        super(members);
    }

    @Override
    public void start() {
        log.info("游泳活动开始");
    }
}
