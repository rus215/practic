package com.rusl215.controller;

import com.rusl215.service.organization.OrganizationService;
import com.rusl215.view.organization.OrganizationListFilterView;
import com.rusl215.view.organization.OrganizationListView;
import com.rusl215.view.organization.OrganizationSaveView;
import com.rusl215.view.organization.OrganizationView;
import com.rusl215.view.success.SuccessResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * @see OrganizationService#filterOrganization(OrganizationListFilterView)
     */
    @PostMapping(value = "/list")
    public List<OrganizationListView> getOrganizationList(@RequestBody OrganizationListFilterView filterView) {

        return organizationService.filterOrganization(filterView);
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
     * @see OrganizationService#updateOrganization(OrganizationView)
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateOrganization(@RequestBody OrganizationView organizationView) {
        return organizationService.updateOrganization(organizationView);
    }

    /**
     * Сохранить организацию
     *
     * @see OrganizationService#saveOrganization(OrganizationSaveView)
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveOrganization(@RequestBody OrganizationSaveView organizationSaveView) {
        return organizationService.saveOrganization(organizationSaveView);
    }
}
