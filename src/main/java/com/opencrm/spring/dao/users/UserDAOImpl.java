package com.opencrm.spring.dao.users;

import com.opencrm.spring.model.users.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip Szylderowicz on 20.07.15.
 */
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {
        Session session = this.sessionFactory.getCurrentSession();

        List<User> users = session.createQuery("from users where username=?").setParameter(0, username).list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }



}
