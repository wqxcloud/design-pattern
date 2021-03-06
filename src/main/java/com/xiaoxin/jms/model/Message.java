package com.xiaoxin.jms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther zhangyongxin
 * @date 2018/5/21 下午5:55
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {


    private static final long serialVersionUID = -7850038612940166189L;

    private String content;
}
