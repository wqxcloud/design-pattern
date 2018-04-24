package com.xiaoxin.designpattern.watcher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 活动组织者
 * @Auther zhangyongxin
 * @date 2018/4/23 下午8:10
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class CompanyActivity {
    private int members;
    public abstract void start();
}
