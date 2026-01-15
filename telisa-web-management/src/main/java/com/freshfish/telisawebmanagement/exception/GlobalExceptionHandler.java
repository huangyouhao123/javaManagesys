package com.freshfish.telisawebmanagement.exception;

import com.freshfish.telisawebmanagement.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("服务器发生异常: {}", e);
        return Result.error("服务器发生异常,请联系管理员");
    }

    @ExceptionHandler
    public Result handleDuplicateEmpException(DuplicateKeyException e){
        String message=e.getMessage();
        int i=message.indexOf("Duplicate entry");
        String msg=message.substring(i+17,message.indexOf("for key",i));
        log.error("员工手机号重复: {}", msg);
        return Result.error("手机号重复");
    }
}
