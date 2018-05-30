package com.xiaoxin.validator.model;

import lombok.experimental.UtilityClass;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 下午12:25
 */
@UtilityClass
public class ResultGenerator {

    public String successCode="200";
    public String successMsg="SUCCESS";
    public String failCode ="201";
    public String failMsg ="ERROR";

    public Result genFailResult(){
        return new Result(failCode,failMsg);
    }
    public Result genFailResult(String failMsg){
        return new Result(failCode,failMsg);
    }
    public Result genSuccessResult(){
        return new Result(successCode,successMsg);
    }
    public Result genSuccessResult(Object object){
        return new Result(successCode,successMsg,object);
    }
    public Result genValidationResult(BindingResult bindingResult){
        assert bindingResult.hasErrors();
        StringBuffer stringBuffer = new StringBuffer();
        for (ObjectError objectError : bindingResult.getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            stringBuffer.append("参数："+fieldError.getField() + "错误:"+ objectError.getDefaultMessage()+";");
        }
        return new Result(failCode,stringBuffer.toString());
    }
}
