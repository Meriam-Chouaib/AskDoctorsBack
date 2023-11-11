package com.project.askdoctor.Exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedHandler extends RuntimeException {
    

 
        private static final long serialVersionUID = 1L;
        public UnauthorizedHandler() {
            super();
        }
        public UnauthorizedHandler(String message) {
            super(message);
        }
        public UnauthorizedHandler(String message, Throwable cause) {
            super(message, cause);
        }
    }

