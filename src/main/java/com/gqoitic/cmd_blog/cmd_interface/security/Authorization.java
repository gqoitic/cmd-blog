package com.gqoitic.cmd_blog.cmd_interface.security;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.model.User;

import java.util.Scanner;

public class Authorization {

    public static User currentUser;

    static Scanner scanner = new Scanner(System.in);

    public static boolean login(){

        Indentions.indention();

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if(!User.listOfUsers.isEmpty()) {
            for (User user : User.listOfUsers) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    currentUser = user;
                    System.out.println("Authorization successful");
                    return true;
                }
            }

            System.out.println("\n      =Incorrect login or password=\n");
            return false;

        } else {
            System.out.println("There is no such user");
        }

        Indentions.indention();
        return false;
    }
}
