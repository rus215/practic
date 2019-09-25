package com.rusl215.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Страна
 */
@Entity
public class Country {
    @Id
    private int code;

    /**
     * Название страны
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * Список граждан страны
     */
    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<User> users;


    /**
     * Конструктор для Hibernate
     */
    public Country() {
    }

    public Country(int code, String name) {
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
     * Добавление гражданина страны
     * @param user - гражданин
     */
    public void addUser(User user){
        getUsers().add(user);
        user.setCountry(this);
    }

    /**
     * Удаление гражданина страны
     * @param user - гражданин
     */
    public void RemoveUser(User user){
        getUsers().remove(user);
        user.setCountry(null);
    }
}
