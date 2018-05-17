package com.xiaoxin.validator.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午11:57
 */
@Getter
@Setter
public class Result implements Serializable {
    private String code;
    private String message;
    private Object data;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Object data) {
        this.data = data;
        this.code = "200";
        this.message = "SUCCESS";
    }
}
