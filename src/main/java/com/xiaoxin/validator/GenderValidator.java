package com.xiaoxin.validator;

import com.xiaoxin.validator.annotation.Gender;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 自定义注解；性别只能为 0、1
 * @Auther zhangyongxin
 * @date 2018/5/17 上午10:59
 */
public class GenderValidator implements ConstraintValidator<Gender, Integer> {
    private final Integer[] ALL_GENDERS = {0,1};

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        if (Arrays.asList(ALL_GENDERS).contains(integer)) {
            return true;
        }
        return false;
    }
}
