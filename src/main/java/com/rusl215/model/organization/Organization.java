package com.rusl215.model.organization;

import com.rusl215.model.office.Office;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

/**
 * Организация
 */
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Сокращенное название организации
     */
    @Column(nullable = false, length = 10)
    private String name;

    /**
     * Полное название организации
     */
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    /**
     * ИНН организации
     */
    @Column(nullable = false, length = 15)
    private String inn;

    /**
     * КПП организации
     */
    @Column(nullable = false, length = 15)
    private String kpp;

    /**
     * Адрес организации
     */
    @Column(nullable = false, length = 50)
    private String address;

    /**
     * Телефон организации
     */
    @Column(length = 15)
    private String phone;

    /**
     * Активность организации
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Офисы организации
     */
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "org_id")
    private List<Office> offices;

    /**
     * Оптимистичная блокировка по полю version
     */
    @Version
    private Integer version;

    /**
     * Конструктор для Hibernate
     */
    public Organization() {
    }

    public Organization(String name, String fullName, String inn, String kpp, String address) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Office> getOffices() {
        if (offices == null) {
            offices = new ArrayList<>();
        }
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    /**
     * Добавление офиса
     *
     * @param office - офис
     */
    public void addOffice(Office office) {
        getOffices().add(office);
    }

    /**
     * Удаление офиса
     *
     * @param office - офис
     */
    public void removeOffice(Office office) {
        getOffices().remove(office);
    }
}
