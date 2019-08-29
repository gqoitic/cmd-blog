package com.gqoitic.cmd_blog.cmd_interface.security;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.cmd_interface.Role;
import com.gqoitic.cmd_blog.model.User;

import java.util.Objects;
import java.util.Scanner;

public class Registration {

    private static Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("UnusedReturnValue")
    public static boolean registration(){

        Indentions.indention();

        if(!Objects.isNull(Authorization.currentUser)){
            System.out.print("\n\n\t\t=You are logged in=\n\n");
            return false;
        }

        System.out.print("Create login: ");
        String login = scanner.nextLine();

        System.out.print("Create password: ");
        String password = scanner.nextLine();

        System.out.print("Create name: ");
        String name = scanner.nextLine();

        if( login.replaceAll("\\s+","").length() < 1        ||
            password.replaceAll("\\s+","").length() < 1     ||
            name.replaceAll("\\s+","").length() < 1
          ) {
                System.out.print("\n\n\tFields cannot be empty!\n");
                return false;
            }

        for(User user : User.listOfUsers){
            if(user.getLogin().equals(login) || user.getName().equals(name)){
                System.out.print("\n\n\tUser with the same login or name already exist!\n");
                return false;
            }
        }

        new User(login, password, name, Role.USER);

        Indentions.indention();
        return true;
    }
}
