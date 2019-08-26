package com.gqoitic.cmd_blog.cmd_interface;

import com.gqoitic.cmd_blog.cmd_interface.commands.PostCommandsList;
import com.gqoitic.cmd_blog.cmd_interface.commands.UserCommandsList;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;
import com.gqoitic.cmd_blog.cmd_interface.security.Registration;

import java.util.Scanner;

import static com.gqoitic.cmd_blog.cmd_interface.commands.CommonCommands.*;
import static com.gqoitic.cmd_blog.cmd_interface.commands.PostCommandsList.*;
import static com.gqoitic.cmd_blog.cmd_interface.commands.UserCommandsList.*;

public class Interf_controller {

    private Scanner scanner = new Scanner(System.in);

    public void applicationProcess(){

        boolean session = true;

        Indentions.userPanel();

        while(session){
            Indentions.pointer();
            String userInput = scanner.nextLine();

            if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(LOGIN.getCommand())){
                Authorization.login();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(EXIT.getCommand())){
                session = false;

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")

                    .equals(REGISTRATION.getCommand())){
                Registration.registration();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(SIGNOUT.getCommand())){
                Authorization.signOut();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(CLEAR.getCommand())){
                Indentions.clear();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(HELP.getCommand())){
                help();

            } else if(userInput.replaceAll("\\s+","").length() < 1) {}

              else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(CHANGENAME.getCommand())){
                UserCommandsList.changeName();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(CHANGEPASSWORD.getCommand())){
                UserCommandsList.changePassword();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(NEWPOST.getCommand())){
                  UserCommandsList.newPost();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(SHOWALLPOSTS.getCommand())){
                PostCommandsList.showAllPosts();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(DELETEPOST.getCommand())){
                  UserCommandsList.deletePost();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(DELETEUSER.getCommand())){
                  UserCommandsList.deleteUser();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(CHANGEROLE.getCommand())){
                  UserCommandsList.changeRole();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(SHOWALLUSERS.getCommand())){
                  UserCommandsList.showAllUsers();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(SHOWPOSTSBYTITLE.getCommand())){
                  PostCommandsList.showPostsByTitle();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(SHOWPOSTSBYAUTHOR.getCommand())){
                  PostCommandsList.showPostsByAuthor();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(MYPOSTS.getCommand())){
                  PostCommandsList.myPosts();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(CHANGETITLE.getCommand())){
                  PostCommandsList.changeTitle();

            } else if(userInput.toUpperCase().replaceAll("\\s+", "")
                    .equals(CHANGETEXT.getCommand())){
                  PostCommandsList.changeText();
            }
             else {
                System.out.printf("%n=            Unknown command \'%s\'   %n%n", userInput);
            }
        }
    }
}
