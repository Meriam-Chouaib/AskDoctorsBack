package com.project.askdoctor.Exception;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ch.qos.logback.classic.Logger;

@ControllerAdvice
public class ApiRequestException extends RuntimeException{

public ApiRequestException (String message){
    super(message);
}
public ApiRequestException (String message, Throwable cause){
    super(message,cause);
}

    public ApiRequestException() {
    }


}