package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

import java.util.Objects;

public enum CommonCommands {
    EXIT("EXIT"),
    LOGIN("LOGIN"),
    REGISTRATION("REGISTRATION"),
    CLEAR("CLEAR"),
    HELP("HELP");


    private String command;

    CommonCommands(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static void help(){
        if(!Objects.isNull(Authorization.currentUser))
            System.out.print("\n\n\t[exit] [login] [signout] [changeName] [clear]\n" +
                             "\t[changePassword] [newPost] [showAllPosts]\n\n");
        else
            System.out.print("\n\n\t[exit] [login] [registration] [clear] [showAllPosts]\n\n");
    }
}
