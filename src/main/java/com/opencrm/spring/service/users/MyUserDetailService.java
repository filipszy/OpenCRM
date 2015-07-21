package com.opencrm.spring.service.users;

import com.opencrm.spring.dao.users.UserDAO;
import com.opencrm.spring.model.users.UserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Filip Szylderowicz on 20.07.15.
 */
public class MyUserDetailService implements UserDetailsService {
    private UserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        // Programmatic transaction management
		/*
		return transactionTemplate.execute(new TransactionCallback<UserDetails>() {

			public UserDetails doInTransaction(TransactionStatus status) {
				com.mkyong.users.model.User user = userDao.findByUserName(username);
				List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

				return buildUserForAuthentication(user, authorities);
			}

		});*/

        com.opencrm.spring.model.users.User user = userDao.findByUserName(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);


    }

    // Converts com.mkyong.users.model.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(com.opencrm.spring.model.users.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }


}
