package com.rusl215.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Страна
 */
@Entity
public class Country {
    @Id
    private int code;

    /**
     * Название страны
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * Конструктор для Hibernate
     */
    public Country() {
    }

    public Country(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
