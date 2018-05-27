package com.xiaoxin.elasticsearch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @Auther zhangyongxin
 * @date 2018/5/27 下午2:38
 */
@EnableElasticsearchRepositories(basePackages = "com.xiaoxin.elasticsearch.repository")
@Slf4j
@Configuration
public class ElasticSearchConfiguration {

//    @Value( "${spring.data.elasticsearch.cluster-name}" )
//    private String clusterName;
//
//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
//        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
//        TransportClient client = new PreBuiltTransportClient(settings)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
//
//        return new ElasticsearchTemplate(client);
//    }

}