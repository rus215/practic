package com.rusl215.controller;

import com.rusl215.service.office.OfficeService;
import com.rusl215.view.office.OfficeListView;
import com.rusl215.view.office.OfficeView;
import com.rusl215.view.success.SuccessResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер офисов
 */
@RestController
@RequestMapping(value = "api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Получить список офисов по фильтрам
     *
     * @param orgId    - идентификатор организации, обязательный параметр
     * @param name     - имя офиса
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     * @return -  список офисов
     */
    @PostMapping(value = "/list")
    public List<OfficeListView> getOfficeList(@RequestParam Long orgId, String name, String phone, Boolean isActive) {
        return officeService.filterOffice(orgId, name, phone, isActive);
    }

    /**
     * Получить офис по идентификатору
     *
     * @param id - идентификатор офиса, обязательный параметр
     * @return - офис
     */
    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@PathVariable Long id) {
        return officeService.officeById(id);
    }

    /**
     * Обновить офис
     *
     * @param id       - идентификатор офиса, обязательный параметр
     * @param name     - имя офиса, обязательный параметр
     * @param address  - адрес офиса, обязательный параметр
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     * @return - сообщение result:success в случае успеха
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateOffice(@RequestParam Long id, @RequestParam String name, @RequestParam String address, String phone, Boolean isActive) {
        return officeService.updateOffice(id, name, address, phone, isActive);
    }

    /**
     * Сохранить офис
     *
     * @param orgId    - идентификатор организации, обязательный параметр
     * @param name     - имя офиса
     * @param address  - адрес офиса
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     * @return - сообщение result:success в случае успеха
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveOffice(@RequestParam Long orgId, String name, String address, String phone, Boolean isActive) {
        return officeService.saveOffice(orgId, name, address, phone, isActive);
    }

}
