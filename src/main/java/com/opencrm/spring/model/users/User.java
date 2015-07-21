package com.opencrm.spring.model.users;

/**
 * Created by Filip Szylderowicz on 20.07.15.
 */
import org.hibernate.id.Assigned;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "users")
@Transactional(readOnly=true)
public class User {

    @Id
    @Column(name = "username", length = 45, nullable = false)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>(0);


    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userRole = userRole;
    }

    //getter and setter methods

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}