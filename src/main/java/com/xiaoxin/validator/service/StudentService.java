package com.xiaoxin.validator.service;

import com.xiaoxin.validator.model.Student;
import org.hibernate.validator.constraints.Length;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午11:04
 */
public interface StudentService {

    Student addOneStudent(Student student);

    Student findOneStudent(String identityId);

    void deleteOneStudent(@Length(min=19,max=19)String identityId);

}
