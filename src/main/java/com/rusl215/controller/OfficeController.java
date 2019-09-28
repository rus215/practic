package com.rusl215.controller;

import com.rusl215.MyUtil;
import com.rusl215.view.success.SuccessResultView;
import com.rusl215.view.office.OfficeListView;
import com.rusl215.view.office.OfficeView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер офисов
 */
@RestController
@RequestMapping(value = "api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    /**
     * Получить список офисов по фильтрам
     * @param orgId    - идентификатор организации, обязательный параметр
     * @param name     - имя офиса
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     * @return -  список офисов
     */
    @PostMapping(value = "/list")
    public List<OfficeListView> getOfficeList(@RequestParam int orgId, String name, String phone, boolean isActive) {
        List<OfficeListView> list = new ArrayList<>();
        list.add(MyUtil.getOfficeListView("1", "Main", true));
        list.add(MyUtil.getOfficeListView("2", "Second", true));
        list.add(MyUtil.getOfficeListView("3", "Third", true));
        return list;
    }

    /**
     * Получить офис по идентификатору
     * @param id - идентификатор офиса, обязательный параметр
     * @return - офис
     */
    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@PathVariable int id) {
        OfficeView view = new OfficeView();
        view.id = String.valueOf(id);
        view.name = "Second";

        return view;
    }

    /**
     * Обновить офис
     * @param id       - идентификатор офиса, обязательный параметр
     * @param name     - имя офиса, обязательный параметр
     * @param address  - адрес офиса, обязательный параметр
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     * @return - сообщение result:success в случае успеха
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateOffice(@RequestParam int id,@RequestParam String name,@RequestParam String address, String phone, boolean isActive){
        return new SuccessResultView();
    }

    /**
     * Сохранить офис
     * @param orgId    - идентификатор организации, обязательный параметр
     * @param name     - имя офиса
     * @param address  - адрес офиса
     * @param phone    - телефон офиса
     * @param isActive - активность офиса
     * @return - сообщение result:success в случае успеха
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveOffice(@RequestParam int orgId, String name, String address, String phone, boolean isActive){
        return new SuccessResultView();
    }

}
