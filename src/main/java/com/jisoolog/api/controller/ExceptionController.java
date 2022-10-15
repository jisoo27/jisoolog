package com.jisoolog.api.controller;


import com.jisoolog.api.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {
//            FieldError fieldError = e.getFieldError();
//            String field = fieldError.getField(); // 어떤 필드가 잘못되었는지 필드명을 알려준다.
//            String message = fieldError.getDefaultMessage(); // 그 필드가 어떻게 잘못되었는지 에러메세지가 넘어간다.
            ErrorResponse response = new ErrorResponse("400", "잘못된 요청입니다.");
        for (FieldError fieldError : e.getFieldErrors()) {
            response.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return response;
    }
}
