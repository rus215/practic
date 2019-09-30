package com.rusl215.model.doc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Тип документа
 */
@Entity
@Table(name = "Doc_Type")
public class DocType {
    @Id
    private Long code;

    /**
     * Название документа
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
    public DocType() {
    }

    public DocType(Long code, String name) {
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
