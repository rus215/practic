package com.rusl215.model.doc;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Статическая метамодель для документа
 */
@StaticMetamodel(value = Doc.class)
public class Doc_ {
    /**
     * Тип документа
     */
    public static volatile SingularAttribute<Doc, DocType> docType;
}
