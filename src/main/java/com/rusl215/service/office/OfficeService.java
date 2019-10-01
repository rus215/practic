package com.rusl215.service.office;

import com.rusl215.view.office.OfficeListView;
import com.rusl215.view.office.OfficeView;
import com.rusl215.view.success.SuccessResultView;

import java.util.List;

/**
 * Сервис для офисов
 */
public interface OfficeService {

    /**
     * Получить список всех офисов по фильтрам
     *
     * @param orgId    - идентификатор организации, обязательный параметр
     * @param name     - имя офиса
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     * @return -  список офисов
     */
    List<OfficeListView> filterOffice(Long orgId, String name, String phone, Boolean isActive);

    /**
     * Получить офис по идентификатору
     *
     * @param id - идентификатор офиса, обязательный параметр
     * @return - офис
     */
    OfficeView officeById(Long id);

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
    SuccessResultView updateOffice(Long id, String name, String address, String phone, Boolean isActive);

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
    SuccessResultView saveOffice(Long orgId, String name, String address, String phone, Boolean isActive);
}
