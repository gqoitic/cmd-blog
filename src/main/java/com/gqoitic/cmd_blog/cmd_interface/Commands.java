package com.gqoitic.cmd_blog.cmd_interface;

import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

import java.util.Objects;

public enum Commands {
    EXIT("EXIT"),
    LOGIN("LOGIN"),
    REGISTRATION("REGISTRATION"),
    SIGNOUT("SIGNOUT"),
    CLEAR("CLEAR"),
    HELP("HELP");


    private String command;

    Commands(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static void help(){
        if(!Objects.isNull(Authorization.currentUser))
            System.out.print("\n\n\t[exit] [login] [registration] [signout] [clear]\n\n");
        else
            System.out.print("\n\n\t[exit] [login] [signout] [clear]\n\n");
    }
}
