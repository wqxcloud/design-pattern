package com.xiaoxin.validator.annotation;

import com.xiaoxin.validator.GenderValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午10:57
 */
@Target( { ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GenderValidator.class})
public @interface Gender {

    String message() default "性别只能为0：女 1：男";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
