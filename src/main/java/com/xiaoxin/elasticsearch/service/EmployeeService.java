package com.xiaoxin.elasticsearch.service;

import com.xiaoxin.elasticsearch.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/5/27 上午11:33
 */
public interface EmployeeService {


    List<Employee> findAll();


}
