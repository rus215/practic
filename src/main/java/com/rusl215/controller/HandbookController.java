package com.rusl215.controller;

import com.rusl215.service.handbook.HandbookService;
import com.rusl215.view.handbook.HandbookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер справочников
 */
@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class HandbookController {
    private HandbookService handbookService;

    @Autowired
    public HandbookController(HandbookService handbookService) {
        this.handbookService = handbookService;
    }

    /**
     * @return - список документов
     */
    @GetMapping(value = "/docs")
    public List<HandbookView> getAllDocs(){
        return handbookService.docs();
    }

    /**
     * @return - список стран
     */
    @GetMapping(value = "/countries")
    public List<HandbookView> getAllContries(){
        return handbookService.countries();
    }
}
