package com.rusl215.controller.advice.response;

import com.rusl215.controller.advice.exception.ExceptionHandling;
import com.rusl215.view.success.SuccessResultView;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "com.rusl215.controller")
public class ResponseHandling implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getContainingClass().isInstance(new ExceptionHandling());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getMethod().getReturnType() == Void.TYPE) {
            return new SuccessResultView();
        }

        return new DataWrapper<>(body);
    }
}
