package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.model.Post;

public enum PostCommandsList {
    SHOWALLPOSTS("SHOWALLPOSTS"),
    SHOWPOSTSBYTITLE("SHOWPOSTSBYTITLE"),
    SHOWPOSTSBYAUTHOR("SHOWPOSTSBYAUTHOR");

    private String command;

    PostCommandsList(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static boolean showAllPosts(){
        Indentions.indention();

        if(Post.listOfPosts.isEmpty()){
            System.out.print("\n\n\t=There is no posts=\n");
            return false;
        }

        for(Post post : Post.listOfPosts){
            System.out.println(post);
        }
        return true;
    }

    public static void showPostsByTitle(){
        PostCommands.showPostsByTitle();
    }
}
