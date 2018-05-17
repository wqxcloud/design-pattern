package com.xiaoxin.validator.controller;

import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import com.xiaoxin.validator.model.Student;
import com.xiaoxin.validator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午11:51
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addOne")
    public Result addOneStudent(){
        Student student = new Student();
        student.setBirthDay(new Date());
        student.setEmail("123163");
        student.setGender(0);
        student.setPhoneNumber("13987654320");
        student.setName("韩梅");
        student.setIdentityId("3412041900000000000");
        student = studentService.addOneStudent(student);
        return new Result(student);
    }

    @PostMapping("/addOneStudent")
    public Result addOneStudent(@RequestBody @Valid Student student, BindingResult bindingResult){

        /**
         * 参数校验
         */
        if(bindingResult.hasErrors()){
            return ResultGenerator.genValidationResult(bindingResult);
        }
        return new Result(studentService.addOneStudent(student));
    }

    @GetMapping("/findOne")
    public Result findOneStudent(@NotEmpty String identityId){
        Student student =  studentService.findOneStudent(identityId);
        return new Result(student);
    }

    @PostMapping("/deleteOne")
    public Result deleteOneStudent(@RequestBody String identityId){
        studentService.deleteOneStudent(identityId);
        return ResultGenerator.genSuccessResult();
    }
}
