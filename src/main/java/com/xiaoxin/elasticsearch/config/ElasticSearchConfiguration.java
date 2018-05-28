package com.xiaoxin.elasticsearch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @Auther zhangyongxin
 * @date 2018/5/27 下午2:38
 */
@EnableElasticsearchRepositories(basePackages = "com.xiaoxin.elasticsearch.repository")
@Configuration
public class ElasticSearchConfiguration {


}