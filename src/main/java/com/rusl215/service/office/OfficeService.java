package com.rusl215.service.office;

import com.rusl215.view.office.OfficeListFilterView;
import com.rusl215.view.office.OfficeListView;
import com.rusl215.view.office.OfficeSaveView;
import com.rusl215.view.office.OfficeView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для офисов
 */
@Validated
public interface OfficeService {

    /**
     * Получить список всех офисов по фильтрам
     *
     * @param filterView - содержит параметры фильтров
     *
     * @return -  список офисов
     */
    List<OfficeListView> filterOffice(@Valid OfficeListFilterView filterView);

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
     * @param officeView - содержит параметры для обновления офиса
     *
     * @return - сообщение result:success в случае успеха
     */
    void updateOffice(@Valid OfficeView officeView);

    /**
     * Сохранить офис
     *
     * @param officeSaveView - содержит параметры для сохранения офиса
     *
     * @return - сообщение result:success в случае успеха
     */
    void saveOffice(@Valid OfficeSaveView officeSaveView);
}
