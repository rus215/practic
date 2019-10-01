package com.rusl215.service.handbook;

import com.rusl215.view.handbook.HandbookView;

import java.util.List;

/**
 * Сервис для справочников
 */
public interface HandbookService {

    /**
     * Получить список всех гражданств
     *
     * @return - список гражданств
     */
    List<HandbookView> countries();

    /**
     * Получить все виды документов
     *
     * @return - список документов
     */
    List<HandbookView> docs();
}