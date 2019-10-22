package com.rusl215.controller;

import com.rusl215.service.user.UserService;
import com.rusl215.view.user.UserListFilterView;
import com.rusl215.view.user.UserListView;
import com.rusl215.view.user.UserSaveView;
import com.rusl215.view.user.UserUpdateView;
import com.rusl215.view.user.UserView;
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
     * @see UserService#filterUser(UserListFilterView)
     */
    @PostMapping(value = "/list")
    public List<UserListView> getUserList(@RequestBody UserListFilterView userListFilterView) {
        return userService.filterUser(userListFilterView);
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
     *@see UserService#updateUser(UserUpdateView)
     */
    @PostMapping(value = "/update")
    public void updateUser(@RequestBody UserUpdateView userUpdateView) {
        userService.updateUser(userUpdateView);
    }

    /**
     * Сохранить данные сотрудника
     *
     * @see UserService#saveUser(UserSaveView)
     */
    @PostMapping(value = "/save")
    public void saveUser(@RequestBody UserSaveView userSaveView) {
        userService.saveUser(userSaveView);
    }
}
