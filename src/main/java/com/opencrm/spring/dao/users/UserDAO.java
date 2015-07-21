package com.opencrm.spring.dao.users;

import com.opencrm.spring.model.users.User;

/**
 * Created by Filip Szylderowicz on 20.07.15.
 */
public interface UserDAO {
    User findByUserName(String username);
}
