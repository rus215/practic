package com.rusl215.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * Тип документа
 */
@Entity
@Table(name = "Doc_Type")
public class DocType {
    @Id
    private int code;

    /**
     * Название документа
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * Конструктор для Hibernate
     */
    public DocType() {
    }

    public DocType(int code, String name) {
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
