package com.rusl215.view.organization;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrganizationSaveView {
    /**
     * сокращенное название организации
     */
    @NotNull(message = "name can not be null")
    @Size(max = 10)
    public String name;
    /**
     * полное название организации
     */
    @NotNull(message = "full name can not be null")
    @Size(max = 50)
    public String fullName;
    /**
     * ИНН организации
     */
    @NotNull(message = "inn can not be null")
    @Size(max = 15)
    public String inn;
    /**
     * КПП организации
     */
    @NotNull(message = "kpp can not be null")
    @Size(max = 15)
    public String kpp;
    /**
     * адрес организации
     */
    @NotNull(message = "address can not be null")
    @Size(max = 50)
    public String address;
    /**
     * телефон организации
     */
    @Size(max = 15)
    public String phone;
    /**
     * активность организации
     */
    public Boolean isActive;
}
