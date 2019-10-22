package com.rusl215.service.organization;

import com.rusl215.view.organization.OrganizationListFilterView;
import com.rusl215.view.organization.OrganizationListView;
import com.rusl215.view.organization.OrganizationSaveView;
import com.rusl215.view.organization.OrganizationView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для организации
 */
@Validated
public interface OrganizationService {

    /**
     * Получить список организаций по фильтрам
     *
     * @param organizationListFilterView - содержит параметры фильтрации
     *
     * @return - список организаций
     */
    List<OrganizationListView> filterOrganization(@Valid OrganizationListFilterView organizationListFilterView);

    /**
     * Получить организацию по идентификатору
     *
     * @param id - идентификатор организации, обязательный параметр
     *
     * @return - организацию
     */
    OrganizationView organizationById(Long id);

    /**
     * Обновить организацию
     *
     * @param organizationView - содержит параметры обновления организации
     *
     * @return - result:success в случае успеха
     */
    void updateOrganization(@Valid OrganizationView organizationView);

    /**
     * Сохранить организацию
     *
     * @param organizationSaveView - содержит параметры сохранения организации
     *
     * @return - сообщение result:success в случае успеха
     */
    void saveOrganization(@Valid OrganizationSaveView organizationSaveView);
}
