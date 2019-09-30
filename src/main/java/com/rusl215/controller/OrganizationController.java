package com.rusl215.controller;

import com.rusl215.service.organization.OrganizationService;
import com.rusl215.view.organization.OrganizationListView;
import com.rusl215.view.organization.OrganizationView;
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
 * Контроллер организаций
 */
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Получить список организаций по фильтрам
     *
     * @param name     - имя организации, обязательный параметр
     * @param inn      - ИНН организации
     * @param isActive - активность организации
     * @return - список организаций
     */
    @PostMapping(value = "/list")
    public List<OrganizationListView> getOrganizationList(@RequestParam String name, String inn, Boolean isActive) {

        return organizationService.filterOrganization(name, inn, isActive);
    }

    /**
     * Получить организацию по идентификатору
     *
     * @param id - идентификатор организации, обязательный параметр
     * @return - организацию
     */
    @GetMapping(value = "/{id}")
    public OrganizationView getOrganizationById(@PathVariable Long id) {
        return organizationService.organizationById(id);
    }

    /**
     * Обновить организацию
     *
     * @param id       - идентификатор организации, обязательный параметр
     * @param name     - сокращенное название организации, обязательный параметр
     * @param fullName - полное название организации, обязательный параметр
     * @param inn      - ИНН организации, обязательный параметр
     * @param kpp      - КПП организации, обязательный параметр
     * @param address  - адрес организации, обязательный параметр
     * @param phone    - телефон организации
     * @param isActive - активность организации
     * @return - result:success в случае успеха
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateOrganization(@RequestParam Long id, @RequestParam String name, @RequestParam String fullName, @RequestParam String inn, @RequestParam String kpp, @RequestParam String address, String phone, Boolean isActive) {
        return organizationService.updateOrganization(id, name, fullName, inn, kpp, address, phone, isActive);
    }

    /**
     * Сохранить организацию
     *
     * @param name     - сокращенное название организации, обязательный параметр
     * @param fullName - полное название организации, обязательный параметр
     * @param inn      - ИНН организации, обязательный параметр
     * @param kpp      - КПП организации, обязательный параметр
     * @param address  - адрес организации, обязательный параметр
     * @param phone    - телефон организации
     * @param isActive - активность организации
     * @return - сообщение result:success в случае успеха
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveOrganization(@RequestParam String name, @RequestParam String fullName, @RequestParam String inn, @RequestParam String kpp, @RequestParam String address, String phone, Boolean isActive) {
        return organizationService.saveOrganization(name, fullName, inn, kpp, address, phone, isActive);
    }
}
