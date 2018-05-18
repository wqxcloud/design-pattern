package com.xiaoxin.validator.service;

import com.xiaoxin.validator.annotation.NeedValidate;
import com.xiaoxin.validator.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午11:05
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class,timeout = 1)
public class StudentServiceImpl implements StudentService {
    @Override
    @NeedValidate
    public Student addOneStudent(Student student, String identityId) {
        log.info("add one student:" + student);
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
        log.info("deleted one student:{}", identityId);
    }

    @Override
    @NeedValidate
    public void updateOneStudentAge(String identityId, Integer age) throws InterruptedException {
        // 测试事物超时
        Thread.sleep(3000);
        log.info("updateOneStudentAge:{},age:{}", identityId, age);
    }
}
