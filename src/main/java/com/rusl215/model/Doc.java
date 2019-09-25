package com.rusl215.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Документ
 */
@Entity
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Дата документа
     */
    @Column(name = "doc_date")
    @Temporal(value = TemporalType.DATE)
    private Date docDate;

    /**
     * Номер документа
     */
    @Column(name = "doc_number", length = 15)
    private String docNumber;

    /**
     * Тип документа
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_code")
    private DocType docType;

    /**
     * Идентифицированный
     */
    @Column(name = "is_identified", nullable = false)
    private boolean isIdentified;

    /**
     * Владелец документа
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    /**
     * Конструктор для Hibernate
     */
    public Doc() {
    }

    public Doc(Date docDate, String docNumber, boolean isIdentified) {
        this.docDate = docDate;
        this.docNumber = docNumber;
        this.isIdentified = isIdentified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
