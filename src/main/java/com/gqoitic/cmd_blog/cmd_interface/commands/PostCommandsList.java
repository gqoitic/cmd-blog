package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;
import com.gqoitic.cmd_blog.model.Post;

import java.util.Objects;

public enum PostCommandsList {
    SHOWALLPOSTS("SHOWALLPOSTS", "SAP"),
    SHOWPOSTSBYTITLE("SHOWPOSTSBYTITLE", "PBT"),
    SHOWPOSTSBYAUTHOR("SHOWPOSTSBYAUTHOR", "PBA"),
    MYPOSTS("MYPOSTS", "MP"),
    CHANGETITLE("CHANGETITLE", "CTITLE"),
    CHANGETEXT("CHANGETEXT", "CTEXT");

    private String command;
    private String shortCommand;

    PostCommandsList(String command, String shortCommand){
        this.command = command;
        this.shortCommand = shortCommand;
    }

    public String getCommand(){
        return command;
    }

    public String getShortCommand(){
        return shortCommand;
    }

    @SuppressWarnings("UnusedReturnValue")
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

    public static void showPostsByAuthor(){
        PostCommands.showPostsByAuthor();
    }

    public static void myPosts(){
        PostCommands.myPosts();
    }

    @SuppressWarnings("UnusedReturnValue")
    public static boolean changeTitle(){
        if(Objects.isNull(Authorization.currentUser)){
            System.out.print("\n\n\t=You are not logged in=\n");
            return false;
        } else {
            PostCommands.changeTitle();
            return true;
        }
    }

    @SuppressWarnings("UnusedReturnValue")
    public static boolean changeText(){
        if(Objects.isNull(Authorization.currentUser)){
            System.out.print("\n\n\t=You are not logged in=\n");
            return false;
        } else {
            PostCommands.changeText();
            return true;
        }
    }
}
