package com.bbs.commom.web;

import com.bbs.commom.exception.CommonException;
import com.bbs.commom.vo.DataResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionController {
    @ExceptionHandler(CommonException.class)
    public DataResult noStackException(CommonException exception){
        log.error("exception,msg:{}",exception.getMessage());
        return DataResult.fail(exception.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataResult noStackException(MethodArgumentNotValidException e){
        log.error("MethodArgumentNotValidException,msg:{}",e.getMessage());
        String msg = e.getAllErrors().get(0).getDefaultMessage();
        return DataResult.fail(msg);
    }
    @ExceptionHandler(Exception.class)
    public DataResult noStackException(Exception exception){
        log.error("exception,",exception);
        return DataResult.fail("未知异常");
    }
}
