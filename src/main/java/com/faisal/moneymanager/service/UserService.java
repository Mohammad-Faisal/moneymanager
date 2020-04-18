package com.faisal.moneymanager.service;

import com.faisal.moneymanager.model.data.User;
import com.faisal.moneymanager.model.request.RegistrationRequest;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

public interface UserService  {

    void save(RegistrationRequest user);
    User findByUsername(String username);
}

