package com.rusl215.view.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserListFilterView {
    /**
     * Идентификатор офиса
     */
    @NotNull(message = "officeId can not be null")
    public Long officeId;
    /**
     * Имя сотрудника
     */
    @Size(max = 20)
    public String firstName;
    /**
     * Фамилия сотрудника
     */
    @Size(max = 20)
    public String lastName;
    /**
     * Отчество сотрудника
     */
    @Size(max = 20)
    public String middleName;
    /**
     * Должность сотрудника
     */
    @Size(max = 50)
    public String position;
    /**
     * Код документа
     */
    public Long docCode;
    /**
     * Код гражданства
     */
    public Long citizenshipCode;
}
