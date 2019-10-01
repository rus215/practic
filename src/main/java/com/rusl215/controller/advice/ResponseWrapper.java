package com.rusl215.controller.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.rusl215.controller")
public class ResponseWrapper implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getContainingClass().isInstance(new ExceptionHandling());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new DataWrapper<>(body);
    }

    /**
     * Класс обертка, оборачивает успешные результаты запросов в параметр data
     *
     * @param <T> - оборачиваемый тип данных
     */
    private static class DataWrapper<T> {
        private T data;

        public DataWrapper(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
