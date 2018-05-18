package com.xiaoxin.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther zhangyongxin
 * @date 2018/5/18 上午9:30
 */
@Target( {ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedValidate {
}
