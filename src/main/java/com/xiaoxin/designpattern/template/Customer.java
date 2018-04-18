package com.xiaoxin.designpattern.template;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午7:11
 */
@Getter
@Setter
@ToString
public class Customer {

    /**
     * 账号类型：手机号1：电子邮件2int
     */
    private int accountType;

    private String account;

    public Customer(int accountType, String account) {
        this.accountType = accountType;
        this.account = account;
    }
}
