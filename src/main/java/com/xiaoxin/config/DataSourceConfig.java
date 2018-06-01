package com.xiaoxin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Auther zhangyongxin
 * @date 2018/5/19 下午12:17
 */
@Configuration
@ConfigurationProperties("spring.datasource")
public class DataSourceConfig extends DruidDataSource{

    @Bean
    @Primary
    public DataSource dataSource(){
        return this;
    }
}
