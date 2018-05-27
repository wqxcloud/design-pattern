package com.xiaoxin.elasticsearch.service.impl;

import com.xiaoxin.elasticsearch.model.Employee;
import com.xiaoxin.elasticsearch.service.EmployeeService;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/5/27 上午11:36
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<Employee> findAll() {
        SearchQuery searchQuery = new NativeSearchQuery(QueryBuilders.matchAllQuery());
        elasticsearchTemplate.queryForList(searchQuery,Employee.class);
        return null;
    }
}
