package com.faisal.moneymanager.service;

import com.faisal.moneymanager.model.data.User;
import com.faisal.moneymanager.model.request.RegistrationRequest;

public interface UserService {

    void save(RegistrationRequest registrationRequest);

    User findByUsername(String username);
}

