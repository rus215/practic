package com.rusl215.view.office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeSaveView {
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
     * адрес офиса
     */
    @Size(max = 50)
    public String address;
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
