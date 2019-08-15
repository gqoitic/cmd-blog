package com.gqoitic.cmd_blog.cmd_interface;

import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;
import com.gqoitic.cmd_blog.cmd_interface.security.Registration;

import java.util.Scanner;

public class Interf_controller {

    private Scanner scanner = new Scanner(System.in);

    public void applicationProcess(){

        boolean session = true;

        Indentions.userPanel();

        while(session){
            Indentions.pointer();
            String userInput = scanner.nextLine();

            if(userInput.toUpperCase().equals(Commands.LOGIN.getCommand())){
                Authorization.login();
            } else if(userInput.toUpperCase().equals(Commands.EXIT.getCommand())){
                session = false;
            } else if(userInput.toUpperCase().equals(Commands.REGISTRATION.getCommand())){
                Registration.registration();
            } else if(userInput.toUpperCase().equals(Commands.SIGNOUT.getCommand())){
                Authorization.signOut();
            } else if(userInput.toUpperCase().equals(Commands.CLEAR.getCommand())){
                Indentions.clear();
            } else if(userInput.toUpperCase().equals(Commands.HELP.getCommand())){
                Commands.help();
            } else if(userInput.replaceAll("\\s+","").length() < 1) {}
              else {
                System.out.printf("%n=            Unknown command \'%s\'   %n%n", userInput);
            }
        }
    }
}
