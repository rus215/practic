package com.rusl215.controller.advice.exception;

/**
 * Класс обертка для ошибок
 */
class ExceptionWrapper {
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