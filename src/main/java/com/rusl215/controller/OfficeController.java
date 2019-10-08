package com.rusl215.controller;

import com.rusl215.service.office.OfficeService;
import com.rusl215.view.office.OfficeListFilterView;
import com.rusl215.view.office.OfficeListView;
import com.rusl215.view.office.OfficeSaveView;
import com.rusl215.view.office.OfficeView;
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
     * @see OfficeService#filterOffice(OfficeListFilterView)
     */
    @PostMapping(value = "/list")
    public List<OfficeListView> getOfficeList(@RequestBody OfficeListFilterView filterView) {
        return officeService.filterOffice(filterView);
    }

    /**
     * Получить офис по идентификатору
     *
     * @see OfficeService#officeById(Long)
     */
    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@PathVariable Long id) {
        return officeService.officeById(id);
    }

    /**
     * Обновить офис
     *
     * @see OfficeService#updateOffice(OfficeView)
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateOffice(@RequestBody OfficeView officeView) {
        return officeService.updateOffice(officeView);
    }

    /**
     * Сохранить офис
     *
     * @see OfficeService#saveOffice(OfficeSaveView)
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveOffice(@RequestBody OfficeSaveView officeSaveView) {
        return officeService.saveOffice(officeSaveView);
    }

}
