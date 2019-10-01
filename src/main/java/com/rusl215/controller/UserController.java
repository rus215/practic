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
     * @see UserService#filterUser(Long, String, String, String, String, Long, Long)
     */
    @PostMapping(value = "/list")
    public List<UserListView> getUserList(@RequestParam Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode) {
        return userService.filterUser(officeId, firstName, lastName, middleName, position, docCode, citizenshipCode);
    }

    /**
     * Получить сотрудника по идентификатору
     *
     * @see UserService#userById(Long)
     */
    @GetMapping(value = "/{id}")
    public UserView getUserById(@PathVariable Long id) {
        return userService.userById(id);
    }

    /**
     * Обновить данные сотрудника
     *
     *@see UserService#updateUser(Long, Long, String, String, String, String, String, String, String, String, Long, Boolean)
     */
    @PostMapping(value = "/update")
    public SuccessResultView updateUser(@RequestParam Long id, Long officeId, @RequestParam String firstName, String secondName, String middleName, @RequestParam String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified) {
        return userService.updateUser(id, officeId, firstName, secondName, middleName, position, phone, docName, docNumber, docDate, citizenshipCode, isIdentified);
    }

    /**
     * Сохранить данные сотрудника
     *
     * @see UserService#saveUser(Long, String, String, String, String, String, String, String, String, Long, Boolean)
     */
    @PostMapping(value = "/save")
    public SuccessResultView saveUser(@RequestParam Long officeId, @RequestParam String firstName, String secondName, String middleName, @RequestParam String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified) {
        return userService.saveUser(officeId, firstName, secondName, middleName, position, phone, docName, docNumber, docDate, citizenshipCode, isIdentified);
    }
}
