package com.faisal.moneymanager.repository;

import com.faisal.moneymanager.model.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Long> {

    User findByUsername(String userName);
}
