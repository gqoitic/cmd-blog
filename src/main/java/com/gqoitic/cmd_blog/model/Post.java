package com.gqoitic.cmd_blog.model;

import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title, text, userName;

    public static List<Post> listOfPosts = new ArrayList<>();

    public Post(String title, String text){
        this.title = title;
        this.text = text;
        this.userName = Authorization.currentUser.getName();

        listOfPosts.add(this);
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getUserName(){
        return userName;
    }

    @Override
    public String toString() {
        return "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n" +
               "TITLE:\t" + title + "\n\n" +
               "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n" +
               text + "\n\n" +
               "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n" +
               "AUTHOR: " + userName +
               "\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                   "===========================================================\n\n\n\n\n";
    }
}
