package com.xiaoxin.validator.service;

import com.xiaoxin.validator.model.Student;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午11:04
 */
public interface StudentService {

    Student addOneStudent(Student student,@Length(min=19,max=19)String identityId);

    Student findOneStudent(String identityId);

    void deleteOneStudent(@Length(min=19,max=19)String identityId);

    void updateOneStudentAge(@Length(min=19,max=19)String identityId,
                          @Max(value = 130,message = "年龄不能超过130岁") Integer age);

}
