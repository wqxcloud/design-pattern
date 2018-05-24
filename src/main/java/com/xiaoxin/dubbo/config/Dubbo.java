package com.xiaoxin.dubbo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther zhangyongxin
 * @date 2018/5/24 上午10:19
 */
@ConfigurationProperties(prefix = "dubbo")
@Getter
@Setter
public class Dubbo {

    private String applicationName;

    private String zookeeperUrl;

    private String serialization;

    private int port;

    private String group;

    private boolean checkOnStartup;

    private int timeOut;

    private String owner;
}
