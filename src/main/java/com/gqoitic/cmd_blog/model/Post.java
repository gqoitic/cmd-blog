package com.gqoitic.cmd_blog.model;

import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

public class Post {
    private String title, text, userLogin;

    public Post(String title, String text){
        this.title = title;
        this.text = text;
        this.userLogin = Authorization.currentUser.getLogin();
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getUserLogin(){
        return userLogin;
    }
}
