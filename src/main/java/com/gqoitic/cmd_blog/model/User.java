package com.gqoitic.cmd_blog.model;

import com.gqoitic.cmd_blog.cmd_interface.Role;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private String name;
    private Role role;

    public static List<User> listOfUsers = new ArrayList<>();

    public User( String login,
                 String password,
                 String name,
                 Role role )
    {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;

        listOfUsers.add(this);
    }

    static {
        User admin = new User("admin", "psw", "ADMIN", Role.ADMIN);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
