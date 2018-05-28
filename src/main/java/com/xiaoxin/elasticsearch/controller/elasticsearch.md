# ElasticSearch使用
## 安装ElasticSearch
你可以从 elastic 的官网 elastic.co/downloads/elasticsearch 获取最新版本的 Elasticsearch
## 安装Sense
> 前提先安装Kibana：https://www.elastic.co/guide/en/kibana/4.6/setup.html
不需要安装elastic/sense

## NOTE:
1. 使用spring-data-elastic-search时需要注意版本需要支持
2. java链接elastic-search的端口号为9300，9200是http端口
3. 看似ElasticsearchRepository和ElasticSearchTemplate有很多相似之处，
实则ElasticSearchTemplate提供了更多的复杂查询的实现，
可以看做是ElasticsearchRepository的补充。
## 安装分词插件
```
1. 安装根据官网指导：https://github.com/medcl/elasticsearch-analysis-ik
2. 重启
[2018-05-28T15:02:51,111][INFO ][o.w.a.d.Monitor          ] try load config from /Users/zhangyongxin/Documents/tools/elasticsearch-6.2.4/config/analysis-ik/IKAnalyzer.cfg.xml
[2018-05-28T15:02:51,114][INFO ][o.w.a.d.Monitor          ] try load config from /Users/zhangyongxin/Documents/tools/elasticsearch-6.2.4/plugins/elasticsearch-analysis-ik-6.2.4/config/IKAnalyzer.cfg.xml
应该就是加载好了。
3. 建立分词mapping 参考：https://www.cnblogs.com/xing901022/p/5910139.html
```
## 支持中文拼音
安装参考：https://github.com/medcl/elasticsearch-analysis-pinyin