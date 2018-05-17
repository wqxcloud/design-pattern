package com.xiaoxin.validator.service;

import com.xiaoxin.validator.model.Student;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午11:04
 */
public interface StudentService {

    Student addOneStudent(Student student);

    Student findOneStudent(String identityId);
}
