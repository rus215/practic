package com.rusl215.controller.advice.response;

/**
 * Класс обертка, оборачивает успешные результаты запросов в параметр data
 *
 * @param <T> - оборачиваемый тип данных
 */
class DataWrapper<T> {
    private T data;

    public DataWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
