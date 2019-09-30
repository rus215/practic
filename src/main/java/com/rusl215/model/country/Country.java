package com.rusl215.model.country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Страна
 */
@Entity
public class Country {
    @Id
    private Long code;

    /**
     * Название страны
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * Оптимистичная блокировка по полю version
     */
    @Version
    private Integer version;

    /**
     * Конструктор для Hibernate
     */
    public Country() {
    }

    public Country(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
