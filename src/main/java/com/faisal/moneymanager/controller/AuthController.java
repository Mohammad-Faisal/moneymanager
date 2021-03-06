package com.faisal.moneymanager.controller;


import com.faisal.moneymanager.model.request.RegistrationRequest;
import com.faisal.moneymanager.model.response.RegistrationResponse;
import com.faisal.moneymanager.service.SecurityService;
import com.faisal.moneymanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Slf4j
public class AuthController  {


    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;


    @PostMapping("/registration")
    public @ResponseBody RegistrationResponse registration(@Valid @RequestBody RegistrationRequest regRequest) {
        userService.save(regRequest);
        securityService.autoLogin(regRequest.getUsername(), regRequest.getPassword());
        return new RegistrationResponse();
    }

}
