package com.zehuang.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@Order(1)
public class RecordTimeAspect {

//    @Around("execution(* com.zehuang.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("方法执行耗时: {}毫秒", endTime - beginTime);
        return result;
    }
}
