package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Role;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

import java.util.Objects;
import java.util.Scanner;

public enum UserCommandsList {
    SIGNOUT("SIGNOUT", "SO"),
    CHANGENAME("CHANGENAME", "CNAME"),
    CHANGEPASSWORD("CHANGEPASSWORD", "CPSW"),
    NEWPOST("NEWPOST", "NP"),
    DELETEPOST("DELETEPOST", "DP"),
    DELETEUSER("DELETEUSER", "DU"),
    CHANGEROLE("CHANGEROLE", "CROLE"),
    SHOWALLUSERS("SHOWALLUSERS", "AU"),
    DELETESELECTEDUSER("DELETESELECTEDUSER", "DSU");

    private String command;
    private String shortCommand;
    static Scanner scanner = new Scanner(System.in);

    UserCommandsList(String command, String shortCommand){
        this.command = command;
        this.shortCommand = shortCommand;
    }

    public String getCommand(){
        return command;
    }

    public String getShortCommand(){
        return shortCommand;
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

        if(Authorization.currentUser.getRole().equals(Role.ADMIN)){
            System.out.print("\n\n\t=You cannot delete admin user=\n");
            return false;
        }

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

    public static boolean changeRole(){
        if(!Objects.isNull(Authorization.currentUser) &&
            Authorization.currentUser.getRole().equals(Role.ADMIN))
        {
            UserCommands.changeRole();
            return true;
        }
        else
        {
            System.out.print("\n\t=You have not enough rights=\n");
            return false;
        }
    }

    public static boolean showAllUsers(){
        if(Objects.isNull(Authorization.currentUser)){
            System.out.print("\n\t=You are not logged in=\n");
            return false;
        }

        if(!Authorization.currentUser.getRole().equals(Role.ADMIN)){
            System.out.print("\n\t=You have not enough rights=\n");
            return false;
        }

        UserCommands.showAllUsers();
        return true;
    }

    public static boolean deleteSelectedUser(){
        if(Objects.isNull(Authorization.currentUser)){
            System.out.print("\n\n\t=You are not logged in=\n");
            return false;
        }

        if(!Authorization.currentUser.getRole().equals(Role.ADMIN)){
            System.out.print("\n\n\t=You have not enough rights=\n");
            return false;
        }

        UserCommands.deleteSelectedUser();
        return true;
    }
}
