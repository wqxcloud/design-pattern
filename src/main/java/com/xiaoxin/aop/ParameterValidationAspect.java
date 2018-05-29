package com.xiaoxin.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.HibernateValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * 参数校验分为bean的和非bean的，bean的参数校验的注解按照代码生成的即可；
 * 非bean的也是使用原来的注解，只不过需要声明在service上。
 *
 * @Auther zhangyongxin
 * @date 2018/5/25 下午1:07
 */
@Slf4j
@Component
@Aspect
public class ParameterValidationAspect {
    private static final String SEMICOLON = ";";

    //标注了@NeedValidate注解的
    @Around("@annotation(com.xiaoxin.validator.annotation.NeedValidate)")
    public Object validateParameters(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
            ExecutableValidator validator = validatorFactory.getValidator().forExecutables();
            Validator beanValidator = validatorFactory.getValidator();
            Set<ConstraintViolation<Object>> violations = new HashSet<>();
            Class clazz = joinPoint.getSignature().getDeclaringType();
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method targetMethod = methodSignature.getMethod();
            // 非java bean的参数校验
            violations.addAll(validator.validateParameters(clazz.newInstance(), targetMethod, args));
            // java Bean的参数校验
            for (Object object : args) {
                violations.addAll(beanValidator.validate(object));
            }
            dealWithValidations(violations);
        }
        return joinPoint.proceed();

    }

    private void dealWithValidations(Set<ConstraintViolation<Object>> violations) {
        if (violations.size() > 0) {
            StringBuffer buf = new StringBuffer();
            for (ConstraintViolation<Object> violation : violations) {
                buf.append(violation.getPropertyPath().toString());
                buf.append(violation.getMessage());
                buf.append(SEMICOLON);
            }
            throw new IllegalArgumentException(buf.toString());
        }
    }
}

