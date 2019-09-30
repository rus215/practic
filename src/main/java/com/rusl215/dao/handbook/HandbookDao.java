package com.rusl215.dao.handbook;

import com.rusl215.model.country.Country;
import com.rusl215.model.doc.DocType;

import java.util.List;

/**
 * DAO для справочников
 */
public interface HandbookDao {

    /**
     * Получить список всех гражданств
     * @return - список гражданств
     */
    List<Country> getAllCountries();

    /**
     * Получить все виды документов
     * @return - список документов
     */
    List<DocType> getAllDocs();
}
