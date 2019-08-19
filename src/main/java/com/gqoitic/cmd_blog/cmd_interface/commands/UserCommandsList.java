package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

import java.util.Objects;

public enum UserCommandsList {
    SIGNOUT("SIGNOUT"),
    CHANGENAME("CHANGENAME"),
    CHANGEPASSWORD("CHANGEPASSWORD"),
    NEWPOST("NEWPOST"),
    DELETEPOST("DELETEPOST");

    private String command;

    UserCommandsList(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static void changeName(){
        if(!Objects.isNull(Authorization.currentUser)){
            UserCommands.changeName();
        } else {
            System.out.print("\n\t=You are not logged in=\n");
        }
    }

    public static void changePassword(){
        if(!Objects.isNull(Authorization.currentUser)){
            UserCommands.changePassword();
        } else {
            System.out.print("\n\t=You are not logged in=\n");
        }
    }

    public static void newPost(){
        if(!Objects.isNull(Authorization.currentUser)){
            UserCommands.newPost();
        } else {
            System.out.print("\n\t=You are not logged in=\n");
        }
    }
}
