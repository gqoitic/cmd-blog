package com.gqoitic.cmd_blog.cmd_interface;

import com.gqoitic.cmd_blog.model.User;

import java.util.Objects;

public class Indentions {

    static void userPanel(){
        indention();

        System.out.println    ("[login]                        [exit]");
    }

    static void indention(){
        for(int i = 5; i >= 0; i--)
            System.out.println("-                                   -");
    }

    static void pointer(){

        User usr = Authorization.currentUser;

        if(Objects.isNull(usr))
            System.out.print("~| ");
        else
            System.out.print("(" + usr.getName() + ")" + " ~| ");
    }
}
