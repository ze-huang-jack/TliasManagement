package com.zehuang.aspect;

import com.zehuang.annotaion.LogOperation;
import com.zehuang.mapper.OperateLogMapper;
import com.zehuang.pojo.OperateLog;
import com.zehuang.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 环绕通知
    @Around("@annotation(log)")
    public Object around(ProceedingJoinPoint joinPoint, LogOperation log) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result.toString());
        operateLog.setCostTime(costTime);

        operateLogMapper.insert(operateLog);
        return result;
    }

    private int getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}
