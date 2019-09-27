package com.rusl215.controller;

import com.rusl215.view.HandbookView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.rusl215.MyUtil.getHandbookView;

/**
 * Контроллер справочников
 */
@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class HandbookController {

    /**
     * @return - возвращает список документов
     */
    @GetMapping(value = "/docs")
    public List<HandbookView> getAllDocs(){
        List<HandbookView> list = new ArrayList<>();
        list.add(getHandbookView("21", "Паспорт гражданина РФ"));
        list.add(getHandbookView("21", "Паспорт гражданина РФ"));

        return list;
    }

    /**
     * @return - возвращает список стран
     */
    @GetMapping(value = "/countries")
    public List<HandbookView> getAllContries(){
        List<HandbookView> list = new ArrayList<>();
        list.add(getHandbookView("643", "Российская Федерация"));
        list.add(getHandbookView("124", "Канада"));
        list.add(getHandbookView("276", "Германия"));

        return list;
    }
}
