package com.faisal.moneymanager.service;


public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
