package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.model.Post;

public enum PostCommandsList {
    SHOWALLPOSTS("SHOWALLPOSTS");

    private String command;

    PostCommandsList(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static void showAllPosts(){
        Indentions.indention();

        for(Post post : Post.listOfPosts){
            System.out.println(post);
        }
    }
}
