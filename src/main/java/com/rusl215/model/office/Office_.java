package com.rusl215.model.office;


import com.rusl215.model.organization.Organization;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Статическая метамодель офиса
 */
@StaticMetamodel(Office.class)
public class Office_ {
    /**
     * Идентификатор офиса
     */
    public static volatile SingularAttribute<Office, Long> id;
    /**
     * Организация офиса
     */
    public static volatile SingularAttribute<Office, Organization> organization;
    /**
     * Название офиса
     */
    public static volatile SingularAttribute<Office, String> name;
    /**
     * Телефон офиса
     */
    public static volatile SingularAttribute<Office, String> phone;
    /**
     * Активность офиса
     */
    public static volatile SingularAttribute<Office, Boolean> isActive;
}
