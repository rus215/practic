package com.rusl215.view.office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeView {
    /**
     * идентификатор офиса
     */
    @NotNull(message = "id can not be null")
    public Long id;
    /**
     * название офиса
     */
    @NotNull(message = "name can not be null")
    @Size(max = 20)
    public String name;
    /**
     * адрес офиса
     */
    @NotNull(message = "address can not be null")
    @Size(max = 50)
    public String address;
    /**
     * телефон офиса
     */
    @Size(max = 15)
    public String phone;
    /**
     * активность офиса
     */
    public Boolean isActive;
}
