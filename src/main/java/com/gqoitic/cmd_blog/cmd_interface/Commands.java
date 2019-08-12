package com.gqoitic.cmd_blog.cmd_interface;

public enum Commands {
    EXIT("EXIT"),
    LOGIN("LOGIN"),
    REGISTRATION("REGISTRATION");

    private String command;

    Commands(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
