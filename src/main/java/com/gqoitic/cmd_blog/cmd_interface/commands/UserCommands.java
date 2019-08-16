package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;

import java.util.Scanner;

public class UserCommands {

    static Scanner scanner = new Scanner(System.in);

    public static void changeName(){
        Indentions.indention();

        System.out.print("\nEnter new name: ");
        String newName = scanner.nextLine();

        Authorization.currentUser.setName(newName);
        Indentions.indention();
    }

    public static void changePassword(){
        Indentions.indention();

        System.out.print("\nEnter new password: ");
        String newPassword = scanner.nextLine();

        Authorization.currentUser.setPassword(newPassword);
        Indentions.indention();
    }
}
