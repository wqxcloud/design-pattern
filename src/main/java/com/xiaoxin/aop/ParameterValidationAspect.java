package com.xiaoxin.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.HibernateValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @Auther zhangyongxin
 * @date 2018/5/17 上午10:11
 */
@Aspect
@Component
@Slf4j
public class ParameterValidationAspect {

    @Around("execution(public * com.xiaoxin..*.service..*.*(..))")
    public Object validaParameters(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("ParameterValidationAspect before " + className + "." + methodName);
        if (null != args && args.length > 0) {
            ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<Object>> violations = new HashSet<>();
            for (Object object : args) {
                violations.addAll(validator.validate(object));
            }
            if (violations.size() > 0) {
                StringBuffer buf = new StringBuffer();
                //消息绑定，国际化实现
//                ResourceBundle bundle = ResourceBundle.getBundle("messages");
                for (ConstraintViolation<Object> violation : violations) {
//                    buf.append("-" + bundle.getString(violation.getPropertyPath().toString()));
                    buf.append("-" + violation.getPropertyPath().toString());
                    buf.append(violation.getMessage() + "<BR>\n");
                }
                throw new IllegalArgumentException(buf.toString());
            }
        }
        return joinPoint.proceed();

    }
}
