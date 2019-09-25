package com.rusl215.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Офис
 */
@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Название офиса
     */
    @Column(nullable = false, length = 20)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(nullable = false, length = 50)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(length = 15)
    private String phone;

    /**
     * Активность офиса
     */
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    /**
     * Организация офиса
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;

    /**
     * Сотрудники офиса
     */
    @OneToMany(mappedBy = "office", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<User> users;

    /**
     * Конструктор для Hibernate
     */
    public Office() {
    }

    public Office(String name, String address, String phone, boolean isActive) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<User> getUsers() {
        if (users == null){
            users = new ArrayList<>();
        }
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Добавление сотрудника
     * @param user - сотрудник
     */
    public void addUser(User user){
        getUsers().add(user);
        user.setOffice(this);
    }

    /**
     * Удаление сотрудника
     * @param user - сотрудник
     */
    public void removeUser(User user){
        getUsers().remove(user);
        user.setOffice(null);
    }
}
