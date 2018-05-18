package com.xiaoxin.validator.service;

import com.xiaoxin.validator.annotation.NeedValidate;
import com.xiaoxin.validator.model.Student;
import com.xiaoxin.validator.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午11:05
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    @NeedValidate
    public Student addOneStudent(Student student,String identityId) {
        log.info("add one student:"+student);
        return student;
    }

    @Override
    public Student findOneStudent(String identityId) {
        Student student = new Student();
        student.setBirthDay(new Date());
        student.setEmail("123@163.com");
        student.setGender(0);
        student.setPhoneNumber("13987654320");
        student.setName("韩梅");
        student.setIdentityId(identityId);
        return student;
    }

    @Override
    public void deleteOneStudent(String identityId) {
        log.info("deleted one student:{}",identityId);
    }

    @Override
    @NeedValidate
    public void updateOneStudentAge(String identityId,Integer age) {
        log.info("updateOneStudentAge:{},age:{}",identityId,age);
    }
}
