package com.faisal.moneymanager.model.request;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class RegistrationRequest  {

    @NotBlank(message = "User name is Mendatory")
    private String username;
    private String password;
}
