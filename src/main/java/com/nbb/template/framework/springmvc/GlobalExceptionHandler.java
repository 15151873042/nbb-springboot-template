package com.nbb.template.framework.springmvc;

import com.nbb.template.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(Throwable.class)
    public Object handleAll(Throwable e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

}
