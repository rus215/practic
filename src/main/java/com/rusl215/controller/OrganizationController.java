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
     * @see OrganizationService#filterOrganization(String, String, Boolean)
     */
    @PostMapping(value = "/list")
    public List<OrganizationListView> getOrganizationList(@RequestParam String name, String inn, Boolean isActive) {

        return organizationService.filterOrganization(name, inn, isActive);
    }

    /**
     * Получить организацию по идентификатору
     *
     * @see OrganizationService#organizationById(Long)
     */
    @GetMapping(value = "/{id}")
    public OrganizationView getOrganizationById(@PathVariable Long id) {
        return organizationService.organizationById(id);
    }

    /**
     * Обновить организацию
     *
     * @see OrganizationService#updateOrganization(Long, String, String, String, String, String, String, Boolean)
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateOrganization(@RequestParam Long id, @RequestParam String name, @RequestParam String fullName, @RequestParam String inn, @RequestParam String kpp, @RequestParam String address, String phone, Boolean isActive) {
        return organizationService.updateOrganization(id, name, fullName, inn, kpp, address, phone, isActive);
    }

    /**
     * Сохранить организацию
     *
     * @see OrganizationService#saveOrganization(String, String, String, String, String, String, Boolean)
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveOrganization(@RequestParam String name, @RequestParam String fullName, @RequestParam String inn, @RequestParam String kpp, @RequestParam String address, String phone, Boolean isActive) {
        return organizationService.saveOrganization(name, fullName, inn, kpp, address, phone, isActive);
    }
}
