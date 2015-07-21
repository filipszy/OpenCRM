package com.opencrm.spring.users.dao;

import com.opencrm.spring.users.model.User;

/**
 * Created by Filip Szylderowicz on 20.07.15.
 */
public interface UserDAO {
    User findByUserName(String username);
}
