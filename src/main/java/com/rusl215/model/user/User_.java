package com.rusl215.model.user;

import com.rusl215.model.country.Country;
import com.rusl215.model.doc.Doc;
import com.rusl215.model.office.Office;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Метамодель для сотрудника
 */
@StaticMetamodel(value = User.class)
public class User_ {
    /**
     * Офис сотрудника
     */
    public static volatile SingularAttribute<User, Office> office;
    /**
     * Имя сотрудника
     */
    public static volatile SingularAttribute<User, String> firstName;
    /**
     * Фамилия сотрудника
     */
    public static volatile SingularAttribute<User, String> secondName;
    /**
     * Отчество сотрудника
     */
    public static volatile SingularAttribute<User, String> middleName;
    /**
     * Должность сотрудника
     */
    public static volatile SingularAttribute<User, String> position;
    /**
     * Документ сотрудника
     */
    public static volatile SingularAttribute<User, Doc> doc;
    /**
     * Гражданство сотрудника
     */
    public static volatile SingularAttribute<User, Country> country;
}
