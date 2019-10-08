package com.rusl215.view.office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeListFilterView {
    /**
     * идентификатор организации
     */
    @NotNull(message = "orgId can not be null")
    public Long orgId;
    /**
     * название офиса
     */
    @Size(max = 20)
    public String name;
    /**
     * название телефон
     */
    @Size(max = 15)
    public String phone;
    /**
     * активность офиса
     */
    public Boolean isActive;
}
