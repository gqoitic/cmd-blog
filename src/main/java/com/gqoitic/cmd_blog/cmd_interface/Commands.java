package com.gqoitic.cmd_blog.cmd_interface;

public enum Commands {
    EXIT("EXIT"),
    LOGIN("LOGIN"),
    REGISTRATION("REGISTRATION"),
    SIGNOUT("SIGNOUT"),
    CLEAR("CLEAR"),
    HELP("HELP");


    private String command;

    Commands(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static void help(){
        System.out.print("\n\n\t[exit] [login] [registration] [signout] [clear]\n\n");
    }
}
