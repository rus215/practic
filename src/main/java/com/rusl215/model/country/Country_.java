package com.rusl215.model.country;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Статическая метамодель для страны
 */
@StaticMetamodel(value = Country.class)
public class Country_ {
    /**
     * Идентификатор страны
     */
    public static volatile SingularAttribute<Country, Long> code;
}
