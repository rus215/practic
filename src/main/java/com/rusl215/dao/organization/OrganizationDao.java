package com.rusl215.dao.organization;

import com.rusl215.model.organization.Organization;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * DAO для организации
 */
public interface OrganizationDao {

    /**
     * Получить список организаций по фильтрам
     *
     * @param name     - имя организации, обязательный параметр
     * @param inn      - ИНН организации
     * @param isActive - активность организации
     * @return - список организаций
     */
    List<Organization> getOrganizationByFilter(@NotNull String name, String inn, Boolean isActive);

    /**
     * Получить организацию по идентификатору
     *
     * @param id - идентификатор организации, обязательный параметр
     * @return - организацию
     */
    Organization getOrganizationById(@NotNull Long id);

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
     */
    void updateOrganization(@NotNull Long id,@NotNull String name,@NotNull String fullName,@NotNull String inn, @NotNull String kpp, @NotNull String address, String phone, Boolean isActive);
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
     */
    void saveOrganization(@NotNull String name,@NotNull String fullName,@NotNull String inn, @NotNull String kpp, @NotNull String address, String phone, Boolean isActive);
}
