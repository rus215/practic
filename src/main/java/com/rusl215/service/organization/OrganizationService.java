package com.rusl215.service.organization;

import com.rusl215.view.organization.OrganizationListView;
import com.rusl215.view.organization.OrganizationView;
import com.rusl215.view.success.SuccessResultView;

import java.util.List;

/**
 * Сервис для организации
 */
public interface OrganizationService {

    /**
     * Получить список организаций по фильтрам
     *
     * @param name     - имя организации, обязательный параметр
     * @param inn      - ИНН организации
     * @param isActive - активность организации
     * @return - список организаций
     */
    List<OrganizationListView> filterOrganization(String name, String inn, Boolean isActive);

    /**
     * Получить организацию по идентификатору
     *
     * @param id - идентификатор организации, обязательный параметр
     * @return - организацию
     */
    OrganizationView organizationById(Long id);

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
    SuccessResultView updateOrganization(Long id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive);

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
    SuccessResultView saveOrganization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive);
}
