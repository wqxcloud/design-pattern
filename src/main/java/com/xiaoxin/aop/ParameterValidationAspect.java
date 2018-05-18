package com.xiaoxin.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
 * 参数的校验分为 bean的校验和其他类型参数校验，需要分开对应。
 * 基本数据类型必须写成包装类型。
 * 方法上的validate如@Max等写在service interface的方法参数上，
 *
 * @NeedValidate 注解写在实现类上
 * @Auther zhangyongxin
 * @date 2018/5/17 上午10:11
 */
@Aspect
@Component
@Slf4j
public class ParameterValidationAspect {

    //标注了@NeedValidate注解的
    @Around("@annotation(com.xiaoxin.validator.annotation.NeedValidate)")
    public Object validateParameters(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("ParameterValidationAspect before " + className + "." + methodName);
        if (null != args && args.length > 0) {
            ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
            ExecutableValidator validator = validatorFactory.getValidator().forExecutables();
            Validator beanValidator = validatorFactory.getValidator();
            Set<ConstraintViolation<Object>> violations = new HashSet<>();
            Class clazz = joinPoint.getSignature().getDeclaringType();
            Class[] classTypes = new Class[args.length];
            // 因为此处获取不带基本类型的数据类型，只能获取对应的包装类型，所以在service层需要写基本类型对应的包装类型的参数
            for (int i = 0; i < args.length; i++) {
                classTypes[i] = args[i].getClass();
            }
            Method method = clazz.getMethod(methodName, classTypes);
            // 非java bean的参数校验
            violations.addAll(validator.validateParameters(clazz.newInstance(), method, args));
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
                buf.append("-" + violation.getPropertyPath().toString());
                buf.append(violation.getMessage() + "<br/>\n");
            }
            throw new IllegalArgumentException(buf.toString());
        }
    }
}
