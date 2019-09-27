package com.rusl215.controller;

import com.rusl215.view.organization.OrganizationListView;
import com.rusl215.view.organization.OrganizationView;
import com.rusl215.view.SuccessResultView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.rusl215.MyUtil.getOrganizationListView;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер организаций
 */
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    /**
     * Получить список организаций по фильтрам
     * @param name - имя организации, обязательный параметр
     * @param inn - ИНН организации
     * @param isActive - активность организации
     * @return - возвращает список организаций
     */
    @PostMapping(value = "/list")
    public List<OrganizationListView> getOrganizationList(@RequestParam String name, String inn, boolean isActive) {
        List<OrganizationListView> list = new ArrayList<>();
        list.add(getOrganizationListView("1", name, false));
        list.add(getOrganizationListView("2", name, true));
        list.add(getOrganizationListView("3", name, true));

        return list;
    }

    /**
     * Получить организацию по идентификатору
     * @param id - идентификатор организации, обязательный параметр
     * @return - возвращает организацию
     */
    @GetMapping(value = "/{id}")
    public OrganizationView getOrganizationById(@PathVariable int id){
        OrganizationView organizationView = new OrganizationView();
        organizationView.id = String.valueOf(id);
        organizationView.address = "ул. Цурюпы 6";
        return organizationView;
    }

    /**
     * Обновить организацию
     * @param id - идентификатор организации, обязательный параметр
     * @param name - сокращенное название организации, обязательный параметр
     * @param fullName - полное название организации, обязательный параметр
     * @param inn - ИНН организации, обязательный параметр
     * @param kpp - КПП организации, обязательный параметр
     * @param address - адрес организации, обязательный параметр
     * @param phone - телефон организации
     * @param isActive - активность организации
     * @return - возвращает сообщение result:success в случае успеха
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateOrganization(@RequestParam int id,@RequestParam String name,@RequestParam String fullName,@RequestParam String inn,@RequestParam String kpp,@RequestParam String address, String phone, boolean isActive){
       return new SuccessResultView();
    }

    /**
     * Сохранить организацию
     * @param name - сокращенное название организации, обязательный параметр
     * @param fullName - полное название организации, обязательный параметр
     * @param inn - ИНН организации, обязательный параметр
     * @param kpp - КПП организации, обязательный параметр
     * @param address - адрес организации, обязательный параметр
     * @param phone - телефон организации
     * @param isActive - активность организации
     * @return - возвращает сообщение result:success в случае успеха
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveOrganization(@RequestParam String name,@RequestParam String fullName,@RequestParam String inn,@RequestParam String kpp,@RequestParam String address, String phone, boolean isActive){
        return new SuccessResultView();
    }
}
