package com.rusl215.view.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdateView {
    /**
     * Идентификатор сотрудника
     */
    @NotNull(message = "id can not be null")
    public Long id;
    /**
     * Идентификатор офиса
     */
    public Long officeId;
    /**
     * Имя сотрудника
     */
    @NotNull(message = "firstName can not be null")
    @Size(max = 20)
    public String firstName;
    /**
     * Фамилия сотрудника
     */
    @Size(max = 20)
    public String secondName;
    /**
     * Отчество сотрудника
     */
    @Size(max = 20)
    public String middleName;
    /**
     * Должность сотрудника
     */
    @NotNull(message = "position can not be null")
    @Size(max = 50)
    public String position;
    /**
     * Телефон сотрудника
     */
    @Size(max = 15)
    public String phone;
    /**
     * Название документа сотрудника
     */
    @Size(max = 50)
    public String docName;
    /**
     * Номер документа сотрудника
     */
    @Size(max = 15)
    public String docNumber;
    /**
     * Дата документа сотрудника
     */
    @Size(max = 10)
    public String docDate;
    /**
     * Код гражданства
     */
    public Long citizenshipCode;
    /**
     * Идентифицированный
     */
    public Boolean isIdentified;
}
