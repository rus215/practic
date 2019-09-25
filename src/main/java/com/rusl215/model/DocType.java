package com.rusl215.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
     * Документы заданного типа
     */
    @OneToMany(mappedBy = "docType", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Doc> docs;

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

    public List<Doc> getDocs() {
        if (docs == null){
            docs = new ArrayList<>();
        }
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    /**
     * Добавление документа
     * @param doc - документ
     */
    public void addDoc(Doc doc){
        getDocs().add(doc);
        doc.setDocType(this);
    }

    /**
     * Удаление документа
     * @param doc - документ
     */
    public void removeDoc(Doc doc){
        getDocs().remove(doc);
        doc.setDocType(null);
    }
}
