package com.pilipili.business.controller;

import com.pilipili.server.dto.ResponseDto;
import com.pilipili.server.exception.BusinessException;
import com.pilipili.server.exception.ValidatorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    public ResponseDto validatorExceptionHandler(ValidatorException e) {
        log.warn(e.getMessage());
        return ResponseDto.fail(e.getMessage());
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseDto businessExceptionHandler(BusinessException e) {
        log.error("业务异常：{}", e.getCode().getDesc());
        return ResponseDto.fail(e.getCode().getDesc());
    }
}
