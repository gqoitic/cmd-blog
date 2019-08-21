package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

import java.util.Objects;
import java.util.Scanner;

public enum UserCommandsList {
    SIGNOUT("SIGNOUT"),
    CHANGENAME("CHANGENAME"),
    CHANGEPASSWORD("CHANGEPASSWORD"),
    NEWPOST("NEWPOST"),
    DELETEPOST("DELETEPOST"),
    DELETEUSER("DELETEUSER");

    private String command;
    static Scanner scanner = new Scanner(System.in);

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

    public static boolean deletePost(){
        if(!Objects.isNull(Authorization.currentUser)){
            UserCommands.deletePost();
            return true;
        } else {
            System.out.print("\n\t=You are not logged in=\n");
            return false;
        }
    }

    public static boolean deleteUser(){
        if(!Objects.isNull(Authorization.currentUser)){
            System.out.print("\nAre you sure you want to delete user? (Y/N): ");
            String input = scanner.nextLine();

            if(input.toUpperCase().equals("Y")) {
                UserCommands.deleteUser();
                return true;
            } else {
                return false;
            }
        } else {
            System.out.print("\n\n\t=You are not logged in=\n");
            return false;
        }
    }
}
