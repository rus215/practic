package com.rusl215.service.user;

import com.rusl215.view.user.UserListFilterView;
import com.rusl215.view.user.UserListView;
import com.rusl215.view.user.UserSaveView;
import com.rusl215.view.user.UserUpdateView;
import com.rusl215.view.user.UserView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для сотрудника
 */
@Validated
public interface UserService {

    /**
     * Получить список сотрудников по фильтрам
     *
     * @param userListFilterView - содержит параметры фильтрации сотрудников
     *
     * @return - список сотрудников
     */
    List<UserListView> filterUser(@Valid UserListFilterView userListFilterView);

    /**
     * Получить сотрудника по идентификатору
     *
     * @param id - идентификатор сотрудника, обязательный параметр
     *
     * @return - сотрудника
     */
    UserView userById(Long id);

    /**
     * Обновить данные сотрудника
     *
     * @param userUpdateView - содержит параметры для обновления сотрудника
     *
     * @return - сообщение result:success в случае успеха
     */
    void updateUser(@Valid UserUpdateView userUpdateView);

    /**
     * Сохранить данные сотрудника
     *
     * @param userSaveView - содержит параметры для сохранения сотрудника
     *
     * @return - сообщение result:success в случае успеха
     */
    void saveUser(@Valid UserSaveView userSaveView);
}
