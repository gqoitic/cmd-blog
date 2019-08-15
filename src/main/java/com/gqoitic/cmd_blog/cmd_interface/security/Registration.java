package com.gqoitic.cmd_blog.cmd_interface.security;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.model.User;

import java.util.Scanner;

public class Registration {

    static Scanner scanner = new Scanner(System.in);

    public static boolean registration(){

        Indentions.indention();

        System.out.print("Create login: ");
        String login = scanner.nextLine();

        System.out.print("Create password: ");
        String password = scanner.nextLine();

        System.out.print("Create name: ");
        String name = scanner.nextLine();

        for(User user : User.listOfUsers){
            if(user.getLogin().equals(login) || user.getName().equals(name)){
                System.out.print("\n\n\tUser with the same login or name already exist!\n");
                return false;
            }
        }
        User user = new User(login, password, name);

        Indentions.indention();
        return true;
    }
}
