package com.rusl215.dao.office;

import com.rusl215.model.office.Office;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * DAO для офисов
 */
public interface OfficeDao {
    /**
     * Получить список всех офисов по фильтрам
     *
     * @param orgId    - идентификатор организации, обязательный параметр
     * @param name     - имя офиса
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     * @return -  список офисов
     */
    List<Office> getAllOfficesByFilter(@NotNull Long orgId, String name, String phone, Boolean isActive);

    /**
     * Получить офис по идентификатору
     *
     * @param id - идентификатор офиса, обязательный параметр
     * @return - офис
     */
    Office getOfficeById(@NotNull Long id);

    /**
     * Обновить офис
     *
     * @param id       - идентификатор офиса, обязательный параметр
     * @param name     - имя офиса, обязательный параметр
     * @param address  - адрес офиса, обязательный параметр
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     */
    void updateOffice(@NotNull Long id, @NotNull String name, @NotNull String address, String phone, Boolean isActive);

    /**
     * Добавить офис
     *
     * @param orgId    - идентификатор организации, обязательный параметр
     * @param name     - имя офиса
     * @param address  - адрес офиса
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     */
    void insertOffice(@NotNull Long orgId, String name, String address, String phone, Boolean isActive);
}
