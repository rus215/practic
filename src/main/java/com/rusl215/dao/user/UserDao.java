package com.rusl215.dao.user;

import com.rusl215.model.user.User;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * DAO для сотрудника
 */
public interface UserDao {

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
    List<User> getUserList(@NotNull Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode);

    /**
     * Получить сотрудника по идентификатору
     *
     * @param id - идентификатор сотрудника, обязательный параметр
     * @return - сотрудника
     */
    User getUserById(@NotNull Long id);

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
     */
    void updateUser(@NotNull Long id, Long officeId, @NotNull String firstName, String secondName, String middleName, @NotNull String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified);

    /**
     * Добавить данные сотрудника
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
     */
    void insertUser(@NotNull Long officeId, @NotNull String firstName, String secondName, String middleName, @NotNull String position, String phone, String docName, String docNumber, String docDate, Long citizenshipCode, Boolean isIdentified);
}
