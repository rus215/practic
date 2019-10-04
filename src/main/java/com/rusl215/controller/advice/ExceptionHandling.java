package com.rusl215.controller.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "com.rusl215.controller")
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntimeException(Exception ex) {
        return new ResponseEntity<>(new ExceptionWrapper(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ExceptionWrapper(ex.getMessage()), status);
    }

    /**
     * Класс обертка для ошибок
     */
    private static class ExceptionWrapper {
        private String error;

        public ExceptionWrapper(String message) {
            this.error = message;
        }

        public String getError() {
            return error;
        }

        public void setError(String message) {
            this.error = message;
        }
    }
}
