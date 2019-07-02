package com.lieve.base.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author sunlijiang
 * @date 2019/6/30
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BizException.class)
    public ResponseEntity bizExceptionHandler(BizException bizException) {
        return ResponseEntity.ok("");
    }
}
