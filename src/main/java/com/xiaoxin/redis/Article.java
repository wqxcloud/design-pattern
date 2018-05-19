package com.xiaoxin.redis;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 下午5:32
 */
@Getter
@Setter
public class Article implements Serializable {
    private static final long serialVersionUID = 9181145828145412132L;

    private String title;

    private String author;

    private Date writeTime;

    private String content;

    private String[] tags;
}
