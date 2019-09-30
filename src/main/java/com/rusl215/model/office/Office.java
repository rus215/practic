package com.rusl215.model.office;

import com.rusl215.model.organization.Organization;
import com.rusl215.model.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

/**
 * Офис
 */
@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название офиса
     */
    @Column(length = 20)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(length = 50)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(length = 15)
    private String phone;

    /**
     * Активность офиса
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Сотрудники офиса
     */
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "office_id")
    private List<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;

    /**
     * Оптимистичная блокировка по полю version
     */
    @Version
    private Integer version;

    /**
     * Конструктор для Hibernate
     */
    public Office() {
    }

    public Office(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    /**
     * Добавление сотрудника
     *
     * @param user - сотрудник
     */
    public void addUser(User user) {
        getUsers().add(user);
    }

    /**
     * Удаление сотрудника
     *
     * @param user - сотрудник
     */
    public void removeUser(User user) {
        getUsers().remove(user);
    }
}
