package com.xiaoxin.elasticsearch.repository;

import com.xiaoxin.elasticsearch.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/5/27 上午11:48
 */
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    Page<Employee> findByFirstName(String firstName, Pageable pageable);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByInterest(String interest);
}
