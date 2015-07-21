package com.opencrm.spring.model.users;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created by Filip Szylderowicz on 20.07.15.
 */

@Entity(name = "user_roles")
public class UserRole{

    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleId;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(targetEntity = User.class)
    private User user;

    @Column(name = "role", length = 45, nullable = false)
    private String role;

    //getter and setter methods

    public UserRole() {
    }

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
