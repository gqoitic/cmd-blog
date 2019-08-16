package com.gqoitic.cmd_blog.cmd_interface;

import com.gqoitic.cmd_blog.cmd_interface.commands.CommonCommands;
import com.gqoitic.cmd_blog.cmd_interface.commands.UserCommandsList;
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

            if(userInput.toUpperCase().equals(CommonCommands.LOGIN.getCommand())){
                Authorization.login();
            } else if(userInput.toUpperCase().equals(CommonCommands.EXIT.getCommand())){
                session = false;
            } else if(userInput.toUpperCase().equals(CommonCommands.REGISTRATION.getCommand())){
                Registration.registration();
            } else if(userInput.toUpperCase().equals(UserCommandsList.SIGNOUT.getCommand())){
                Authorization.signOut();
            } else if(userInput.toUpperCase().equals(CommonCommands.CLEAR.getCommand())){
                Indentions.clear();
            } else if(userInput.toUpperCase().equals(CommonCommands.HELP.getCommand())){
                CommonCommands.help();
            } else if(userInput.replaceAll("\\s+","").length() < 1) {}

              else if(userInput.toUpperCase().equals(UserCommandsList.CHANGENAME.getCommand())){
                UserCommandsList.changeName();
            } else if(userInput.toUpperCase().equals(UserCommandsList.CHANGEPASSWORD.getCommand())){
                UserCommandsList.changePassword();
            }
             else {
                System.out.printf("%n=            Unknown command \'%s\'   %n%n", userInput);
            }
        }
    }
}
