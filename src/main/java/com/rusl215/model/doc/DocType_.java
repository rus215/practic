package com.rusl215.model.doc;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Статическая метамодель для типа документа
 */
@StaticMetamodel(value = DocType.class)
public class DocType_ {
    /**
     * Код типа документа
     */
    public static volatile SingularAttribute<DocType, Long> code;
    /**
     * Название типа документа
     */
    public static volatile SingularAttribute<DocType, String> name;
}
