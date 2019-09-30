package com.rusl215.controller;

import com.rusl215.service.user.UserService;
import com.rusl215.view.success.SuccessResultView;
import com.rusl215.view.user.UserListView;
import com.rusl215.view.user.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер сотрудников
 */
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получить список сотрудников по фильтрам
     *
     * @param officeId        - идентификатор офиса, обязательный параметр
     * @param firstName       - имя сотрудника
     * @param lastName        - фамилия сотрудника
     * @param middleName      - отчество сотрудника
     * @param position        - должность сотрудника
     * @param docCode         - идентификатор документа
     * @param citizenshipCode - идентификатор гражданства
     * @return - список сотрудников
     */
    @PostMapping(value = "/list")
    public List<UserListView> getUserList(@RequestParam Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode) {
        return userService.filterUser(officeId, firstName, lastName, middleName, position, docCode, citizenshipCode);
    }

    /**
     * Получить сотрудника по идентификатору
     *
     * @param id - идентификатор сотрудника, обязательный параметр
     * @return - сотрудника
     */
    @GetMapping(value = "/{id}")
    public UserView getUserById(@PathVariable Long id) {
        return userService.userById(id);
    }

    /**
     * Обновить данные сотрудника
     *
     * @param id              - идентификатор сотрудника, обязательный параметр
     * @param officeId        - идентификатор офиса
     * @param firstName       - имя сотрудника, обязательный параметр
     * @param secondName      - фамилия сотрудника
     * @param middleName      - отчество сотрудника
     * @param position        - должность сотрудника, обязательный параметр
     * @param phone           - телефон сотрудника
     * @param docName         - название документа сотрудника
     * @param docNumber       - номер документа
     * @param docDate         - дата документа
     * @param citizenshipCode - код гражданства сотрудника
     * @param isIdentified    - идентифицированность
     * @return - сообщение result:success в случае успеха
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateUser(@RequestParam Long id, Long officeId, @RequestParam String firstName, String secondName, String middleName, @RequestParam String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified) {
        return userService.updateUser(id, officeId, firstName, secondName, middleName, position, phone, docName, docNumber, docDate, citizenshipCode, isIdentified);
    }

    /**
     * Сохранить данные сотрудника
     *
     * @param officeId        - идентификатор офиса, обязательный параметр
     * @param firstName       - имя сотрудника, обязательный параметр
     * @param secondName      - фамилия сотрудника
     * @param middleName      - отчество сотрудника
     * @param position        - должность сотрудника, обязательный параметр
     * @param phone           - телефон сотрудника
     * @param docName         - название документа сотрудника
     * @param docNumber       - номер документа
     * @param docDate         - дата документа
     * @param citizenshipCode - код гражданства сотрудника
     * @param isIdentified    - идентифицированность
     * @return - сообщение result:success в случае успеха
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveUser(@RequestParam Long officeId, @RequestParam String firstName, String secondName, String middleName, @RequestParam String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified) {
        return userService.saveUser(officeId, firstName, secondName, middleName, position, phone, docName, docNumber, docDate, citizenshipCode, isIdentified);
    }
}
