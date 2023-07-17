package com.edu.commons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 处理系统的全局异常
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/16 8:31
 * @Version
 */

@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ExceptionHandler(Exception ex){
        String message = ex.getMessage();
//        log.info(message);

        return Result.buildErrorResult(ex.getMessage());
    }
}

