package com.gqoitic.cmd_blog.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private String name;

    public static List<User> listOfUsers = new ArrayList<>();

    public User( String login,
                 String password,
                 String name )
    {
        this.login = login;
        this.password = password;
        this.name = name;

        listOfUsers.add(this);
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
}
