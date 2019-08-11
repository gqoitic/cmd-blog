package com.gqoitic.cmd_blog.cmd_interface;

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
            }
        }
    }
}
