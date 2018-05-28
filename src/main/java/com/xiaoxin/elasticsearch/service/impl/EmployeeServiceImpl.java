package com.xiaoxin.elasticsearch.service.impl;

import com.xiaoxin.elasticsearch.model.Employee;
import com.xiaoxin.elasticsearch.repository.EmployeeRepository;
import com.xiaoxin.elasticsearch.service.EmployeeService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortMode;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.redis.core.query.SortQueryBuilder;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        SearchQuery searchQuery = new NativeSearchQuery(QueryBuilders.matchAllQuery());
        List<Employee> list= elasticsearchTemplate.queryForList(searchQuery,Employee.class);
        return list;
    }

    /**
     * 根据关键字全文模糊匹配，并且通过你年龄降序排列
     * @param keyword
     * @return
     */
    @Override
    public List<Employee> findByKeywordAndSortByAge(String keyword) {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        SearchQuery searchQuery =nativeSearchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(keyword))
                .withSort(SortBuilders.fieldSort("age").order(SortOrder.DESC)).build();
        List<Employee> list = elasticsearchTemplate.queryForList(searchQuery,Employee.class);
        return list;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


}
