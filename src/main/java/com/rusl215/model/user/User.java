package com.rusl215.model.user;

import com.rusl215.model.country.Country;
import com.rusl215.model.doc.Doc;
import com.rusl215.model.office.Office;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Сотрудник
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Оптимистичная блокировка по полю version
     */
    @Version
    private Integer version;

    /**
     * Имя сотрудника
     */
    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    /**
     * Фамилия сотрудника
     */
    @Column(name = "second_name", length = 20)
    private String secondName;

    /**
     * Отчество сотрудника
     */
    @Column(name = "middle_name", length = 20)
    private String middleName;

    /**
     * Должность сотрудника
     */
    @Column(length = 50, nullable = false)
    private String position;

    /**
     * Телефон сотрудника
     */
    @Column(length = 15)
    private String phone;

    /**
     * Офис сотрудника
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Гражданство сотрудника
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_code")
    private Country country;

    /**
     * Документ сотрудника
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Doc doc;

    /**
     * Конструктор для Hibernate
     */
    public User() {
    }

    public User(String firstName, String position) {
        this.firstName = firstName;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
