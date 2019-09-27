package com.rusl215.controller.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.rusl215.controller")
public class ResponseWrapper implements ResponseBodyAdvice {
    /**
     * метод, разрешающий оборачивание объектов
     * @param methodParameter - параметры класса данных
     * @param aClass - класс данных
     * @return - возвращает true в случае если оборачивание разрешено и false в противном случае
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * Метод оборачивания успешных результатов запросов
     * @param body - результат запроса
     * @param methodParameter - параметры класса данных
     * @param mediaType - тип возвращаемых данных данных
     * @param aClass - класс данных
     * @param serverHttpRequest - http запрос
     * @param serverHttpResponse - http ответ
     * @return - возвращает данные, обернутые параметром data
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new DataWrapper<>(body);
    }

    /**
     * Класс обертка, оборачивает успешные результаты запросов в параметр data
     * @param <T> - оборачиваемый тип данных
     */
    private class DataWrapper<T>{
        private T data;

        public DataWrapper(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
