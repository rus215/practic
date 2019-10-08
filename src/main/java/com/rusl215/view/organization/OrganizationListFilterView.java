package com.rusl215.view.organization;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrganizationListFilterView {

    /**
     * Сокращенное название организации
     */
    @NotNull( message = "name can not be null")
    @Size(max = 10)
    public String name;

    /**
     * ИНН организации
     */
    @Size(max = 15)
    public String inn;

    /**
     * Активность организации
     */
    public Boolean isActive;
}
