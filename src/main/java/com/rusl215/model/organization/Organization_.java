package com.rusl215.model.organization;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Статическая метамодель для организации
 */
@StaticMetamodel(value = Organization.class)
public class Organization_ {
    /**
     * Идентификатор организации
     */
    public static volatile SingularAttribute<Organization, Long> id;
    /**
     * Название организации
     */
    public static volatile SingularAttribute<Organization, String> name;
    /**
     * ИНН организации
     */
    public static volatile SingularAttribute<Organization, String> inn;
    /**
     * Активность организации
     */
    public static volatile SingularAttribute<Organization, Boolean> isActive;
}
