package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Role;
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
            if(Authorization.currentUser.getRole().equals(Role.ADMIN))
                System.out.print("\n\n\t[exit] [login] [signout] [changeName] [clear]\n" +
                                 "\t[changePassword] [newPost] [showAllPosts] [deletePost]\n" +
                                 "\t[deleteUser] [changeRole] [showAllUsers] [showPostsByTitle]\n" +
                                 "\t[showPostsByAuthor] [myPosts] [changeTitle] [changeText]\n" +
                                 "\t[deleteSelectedUser]\n\n");

            else if(Authorization.currentUser.getRole().equals(Role.MODER))
                System.out.print("\n\n\t[exit] [login] [signout] [changeName] [clear]\n" +
                                 "\t[changePassword] [newPost] [showAllPosts] [deletePost]\n" +
                                 "\t[deleteUser] [showAllUsers] [showPostsByTitle] [showPostsByAuthor]\n" +
                                 "\t[myPosts] [changeTitle] [changeText]\n\n");

            else
                System.out.print("\n\n\t[exit] [login] [signout] [changeName] [clear]\n" +
                                 "\t[changePassword] [newPost] [showAllPosts] [deletePost]\n" +
                                 "\t[deleteUser] [showPostsByTitle] [showPostsByAuthor] [myPosts]\n" +
                                 "\t[changeTitle] [changeText]\n\n");

        else
            System.out.print("\n\n\t[exit] [login] [registration] [clear] [showAllPosts]\n\n");
    }
}
