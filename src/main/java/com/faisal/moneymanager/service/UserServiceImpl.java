package com.faisal.moneymanager.service;

import com.faisal.moneymanager.model.data.User;
import com.faisal.moneymanager.model.request.RegistrationRequest;
import com.faisal.moneymanager.repository.RoleRepository;
import com.faisal.moneymanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(RegistrationRequest registrationRequest) {

        User user = User.builder()
                .username(registrationRequest.getUsername())
                .password(registrationRequest.getPassword())
                .build();
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}