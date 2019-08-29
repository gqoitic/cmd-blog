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
            String formattedUserInput = userInput.toUpperCase().replaceAll("\\s+", "");

            if(formattedUserInput.equals(LOGIN.getCommand())                           ||
               formattedUserInput.equals(LOGIN.getShortCommnad()))
            {
                Authorization.login();

            } else if(formattedUserInput.equals(EXIT.getCommand())                     ||
                      formattedUserInput.equals(EXIT.getShortCommnad()))
            {
                session = false;

            } else if(formattedUserInput.equals(REGISTRATION.getCommand())             ||
                      formattedUserInput.equals(REGISTRATION.getShortCommnad()))
            {
                Registration.registration();

            } else if(formattedUserInput.equals(SIGNOUT.getCommand())                  ||
                      formattedUserInput.equals(SIGNOUT.getShortCommand()))
            {
                Authorization.signOut();

            } else if(formattedUserInput.equals(CLEAR.getCommand())                    ||
                      formattedUserInput.equals(CLEAR.getShortCommnad()))
            {
                Indentions.clear();

            } else if(formattedUserInput.equals(HELP.getCommand())                     ||
                      formattedUserInput.equals(HELP.getShortCommnad()))
            {
                help();

            } else //noinspection StatementWithEmptyBody
                if(formattedUserInput.length() < 1) {}

              else if(formattedUserInput.equals(CHANGENAME.getCommand())               ||
                      formattedUserInput.equals(CHANGENAME.getShortCommand()))
              {
                UserCommandsList.changeName();

            } else if(formattedUserInput.equals(CHANGEPASSWORD.getCommand())           ||
                      formattedUserInput.equals(CHANGEPASSWORD.getShortCommand()))
            {
                UserCommandsList.changePassword();

            } else if(formattedUserInput.equals(NEWPOST.getCommand())                  ||
                      formattedUserInput.equals(NEWPOST.getShortCommand()))
            {
                  UserCommandsList.newPost();

            } else if(formattedUserInput.equals(SHOWALLPOSTS.getCommand())             ||
                      formattedUserInput.equals(SHOWALLPOSTS.getShortCommand()))
            {
                PostCommandsList.showAllPosts();

            } else if(formattedUserInput.equals(DELETEPOST.getCommand())               ||
                      formattedUserInput.equals(DELETEPOST.getShortCommand()))
            {
                  UserCommandsList.deletePost();

            } else if(formattedUserInput.equals(DELETEUSER.getCommand())               ||
                      formattedUserInput.equals(DELETEUSER.getShortCommand()))
            {
                  UserCommandsList.deleteUser();

            } else if(formattedUserInput.equals(CHANGEROLE.getCommand())               ||
                      formattedUserInput.equals(CHANGEROLE.getShortCommand()))
            {
                  UserCommandsList.changeRole();

            } else if(formattedUserInput.equals(SHOWALLUSERS.getCommand())             ||
                      formattedUserInput.equals(SHOWALLUSERS.getShortCommand()))
            {
                  UserCommandsList.showAllUsers();

            } else if(formattedUserInput.equals(SHOWPOSTSBYTITLE.getCommand())         ||
                      formattedUserInput.equals(SHOWPOSTSBYTITLE.getShortCommand()))
            {
                  PostCommandsList.showPostsByTitle();

            } else if(formattedUserInput.equals(SHOWPOSTSBYAUTHOR.getCommand())        ||
                      formattedUserInput.equals(SHOWPOSTSBYAUTHOR.getShortCommand()))
            {
                  PostCommandsList.showPostsByAuthor();

            } else if(formattedUserInput.equals(MYPOSTS.getCommand())                  ||
                      formattedUserInput.equals(MYPOSTS.getShortCommand()))
            {
                  PostCommandsList.myPosts();

            } else if(formattedUserInput.equals(CHANGETITLE.getCommand())              ||
                      formattedUserInput.equals(CHANGETITLE.getShortCommand()))
            {
                  PostCommandsList.changeTitle();

            } else if(formattedUserInput.equals(CHANGETEXT.getCommand())               ||
                      formattedUserInput.equals(CHANGETEXT.getShortCommand()))
            {
                  PostCommandsList.changeText();

            } else if(formattedUserInput.equals(DELETESELECTEDUSER.getCommand())       ||
                      formattedUserInput.equals(DELETESELECTEDUSER.getShortCommand()))
            {
                  UserCommandsList.deleteSelectedUser();
            }

             else {
                System.out.printf("%n=            Unknown command \'%s\'   %n%n", userInput);
            }
        }
    }
}
