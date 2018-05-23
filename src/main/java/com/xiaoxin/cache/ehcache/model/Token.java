package com.xiaoxin.cache.ehcache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/5/23 上午9:56
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private Date createDate;

    private String userId;
}
