package com.rusl215.controller;

import com.rusl215.view.SuccessResultView;
import com.rusl215.view.user.UserListView;
import com.rusl215.view.user.UserView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.rusl215.MyUtil.getUserListView;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер сотрудников
 */
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    /**
     * Получить список сотрудников по фильтрам
     * @param officeId - идентификатор офиса, обязательный параметр
     * @param firstName - имя сотрудника
     * @param lastName - фамилия сотрудника
     * @param middleName - отчество сотрудника
     * @param position - должность сотрудника
     * @param docCode - идентификатор документа
     * @param citizenshipCode - идентификатор гражданства
     * @return - возвращает список сотрудников
     */
    @PostMapping(value = "/list")
    public List<UserListView> getUserList(@RequestParam int officeId, String firstName, String lastName, String middleName, String position, Integer docCode, Integer citizenshipCode) {
        List<UserListView> list = new ArrayList<>();
        list.add(getUserListView("1", "Илья", "Зубарев", "Евгеньевич", "Менеджер"));
        list.add(getUserListView("2", "Андрей", "Пономарев", "Артурович", "Менеджер"));
        list.add(getUserListView("3", "Иван", "Погодин", "Сергеевич", "Менеджер"));

        return list;
    }

    /**
     * Получить сотрудника по идентификатору
     * @param id - идентификатор сотрудника
     * @return - возвращает сотрудника, обязательный параметр
     */
    @GetMapping(value = "/{id}")
    public UserView getUserById(@PathVariable int id) {
        UserView userView = new UserView();
        userView.id = String.valueOf(id);
        return userView;
    }

    /**
     * Обновить данные сотрудника
     * @param id - идентификатор сотрудника, обязательный параметр
     * @param officeId - идентификатор офиса
     * @param firstName - имя сотрудника, обязательный параметр
     * @param secondName - фамилия сотрудника
     * @param middleName - отчество сотрудника
     * @param position - должность сотрудника, обязательный параметр
     * @param phone - телефон сотрудника
     * @param docName - название документа сотрудника
     * @param docNumber - номер документа
     * @param docDate - дата документа
     * @param citizenshipCode - код гражданства сотрудника
     * @param isIdentified - идентифицированность
     * @return - возвращает сообщение result:success в случае успеха
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateUser(@RequestParam int id, Integer officeId, @RequestParam String firstName, String secondName, String middleName, @RequestParam String position, String phone, String docName, Integer docNumber, String docDate, Integer citizenshipCode, boolean isIdentified){
        return new SuccessResultView();
    }

    /**
     * Сохранить данные сотрудника
     * @param officeId - идентификатор офиса, обязательный параметр
     * @param firstName - имя сотрудника, обязательный параметр
     * @param secondName - фамилия сотрудника
     * @param middleName - отчество сотрудника
     * @param position - должность сотрудника, обязательный параметр
     * @param phone - телефон сотрудника
     * @param docName - название документа сотрудника
     * @param docNumber - номер документа
     * @param docDate - дата документа
     * @param citizenshipCode - код гражданства сотрудника
     * @param isIdentified - идентифицированность
     * @return - возвращает сообщение result:success в случае успеха
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveUser(@RequestParam int officeId, @RequestParam String firstName, String secondName, String middleName, @RequestParam String position, String phone, String docName, Integer docNumber, String docDate, Integer citizenshipCode, boolean isIdentified){
        return new SuccessResultView();
    }
}
