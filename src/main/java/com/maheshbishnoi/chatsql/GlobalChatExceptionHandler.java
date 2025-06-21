package com.maheshbishnoi.chatsql;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalChatExceptionHandler {
    @ExceptionHandler(exception = {EmptyResultException.class, InvalidQueryException.class})
    public String handleException(Exception ex){
        return ex.getMessage();
    }
}
