package com.xiaoxin.current.semaphore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther zhangyongxin
 * @date 2018/5/13 下午6:50
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class Customer implements Runnable {
    protected Money money;
    protected Bank bank;
}
