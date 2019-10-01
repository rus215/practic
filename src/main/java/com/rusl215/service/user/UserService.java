package com.rusl215.service.user;

import com.rusl215.view.success.SuccessResultView;
import com.rusl215.view.user.UserListView;
import com.rusl215.view.user.UserView;

import java.util.List;

/**
 * Сервис для сотрудника
 */
public interface UserService {

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
    List<UserListView> filterUser(Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode);

    /**
     * Получить сотрудника по идентификатору
     *
     * @param id - идентификатор сотрудника, обязательный параметр
     * @return - сотрудника
     */
    UserView userById(Long id);

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
    SuccessResultView updateUser(Long id, Long officeId, String firstName, String secondName, String middleName, String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified);

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
    SuccessResultView saveUser(Long officeId, String firstName, String secondName, String middleName, String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified);
}
