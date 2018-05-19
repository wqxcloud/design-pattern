package com.xiaoxin.redis;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 上午11:24
 */
@Getter
@Setter
public class BrandHotInfo implements Serializable {

    private static final long serialVersionUID = 2951649602293845014L;
    private int userId;

    private String brandName;
}
