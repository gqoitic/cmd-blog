package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Role;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

import java.util.Objects;

public enum CommonCommands {
    EXIT("EXIT", "Q"),
    LOGIN("LOGIN", "LG"),
    REGISTRATION("REGISTRATION", "RG"),
    CLEAR("CLEAR", "CL"),
    HELP("HELP", "H");


    private String command;
    private String shortCommand;

    CommonCommands(String command, String shortCommand){
        this.command = command;
        this.shortCommand = shortCommand;
    }

    public String getCommand(){
        return command;
    }

    public String getShortCommnad(){
        return shortCommand;
    }

    public static void help(){
        if(!Objects.isNull(Authorization.currentUser))
            if(Authorization.currentUser.getRole().equals(Role.ADMIN))
                System.out.print("\n\n\t[exit | q] [login | lg] [signout | so] [changeName | cname] [clear | cl]\n" +
                                 "\t[changePassword | cpsw] [newPost | np] [showAllPosts | sap] [deletePost | dp]\n" +
                                 "\t[deleteUser | du] [changeRole | crole] [showAllUsers  | au] [showPostsByTitle | pbt]\n" +
                                 "\t[showPostsByAuthor | pba] [myPosts | mp] [changeTitle | ctitle] [changeText | ctext]\n" +
                                 "\t[deleteSelectedUser | dsu] [help | h]\n\n");

            else if(Authorization.currentUser.getRole().equals(Role.MODER))
                System.out.print("\n\n\t[exit | q] [login | lg] [signout | so] [changeName | cname] [clear | cl]\n" +
                                 "\t[changePassword | cpsw] [newPost | np] [showAllPosts | sap] [deletePost | dp]\n" +
                                 "\t[deleteUser | du] [showAllUsers | au] [showPostsByTitle | pbt] [showPostsByAuthor | pba]\n" +
                                 "\t[myPosts | mp] [changeTitle | ctitle] [changeText | ctext] [help | h]\n\n");

            else
                System.out.print("\n\n\t[exit | q] [login | lg] [signout | so] [changeName | cname] [clear | cl]\n" +
                                 "\t[changePassword | cpsw] [newPost | np] [showAllPosts | sap] [deletePost | dp]\n" +
                                 "\t[deleteUser | du] [showPostsByTitle | pbt] [showPostsByAuthor | pba] [myPosts | mp]\n" +
                                 "\t[changeTitle | ctitle] [changeText | ctext] [help | h]\n\n");

        else
            System.out.print("\n\n\t[exit | q] [login | lg] [registration | rg] [clear | cl] [showAllPosts | sap] [help | h]\n\n");
    }
}
