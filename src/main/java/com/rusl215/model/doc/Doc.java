package com.rusl215.model.doc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

/**
 * Документ
 */
@Entity
public class Doc {
    @Id
    private Long id;

    /**
     * Оптимистичная блокировка по полю version
     */
    @Version
    private Integer version;

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
     * Идентифицированный
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * Тип документа
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_code")
    private DocType docType;

    /**
     * Конструктор для Hibernate
     */
    public Doc() {
    }

    public Doc(Long id, Date docDate, String docNumber, DocType docType, Boolean isIdentified) {
        this.id = id;
        this.docDate = docDate;
        this.docNumber = docNumber;
        this.docType = docType;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

}
