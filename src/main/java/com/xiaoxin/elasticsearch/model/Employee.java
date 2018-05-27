package com.xiaoxin.elasticsearch.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Auther zhangyongxin
 * @date 2018/5/27 上午11:33
 */
@Getter
@Setter
@Document(indexName="megacorp",type = "employee")
public class Employee {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String about;

    private String[] interest;

}
