package com.faisal.moneymanager.model.request;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class RegistrationRequest  {

    @NotNull(message = "User name is Mendatory")
    private String username;
    private String password;
}
