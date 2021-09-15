package com.example.examplerest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplerest.exception
 * @author:yanggaoli
 * @createTime:2021/9/14 23:49
 * @version:1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =Exception.class)
    public ResponseEntity exceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        return ResponseEntity.ok(e.getMessage());
    }

    @ExceptionHandler(value =MyException.class)
    public ResponseEntity myExceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        return ResponseEntity.ok(e.getMessage());
    }

    @ExceptionHandler(value =SubMyException.class)
    public ResponseEntity subMyExceptionHandler(SubMyException e){
        System.out.println("我是自异常未知异常！原因是:"+e);
        return ResponseEntity.ok(e);
    }
}
