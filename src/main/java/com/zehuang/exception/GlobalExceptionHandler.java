package com.zehuang.exception;

import com.zehuang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        log.error("程序出错了", e);
        return Result.error("出错了，但这不是你的错");
    }
}
