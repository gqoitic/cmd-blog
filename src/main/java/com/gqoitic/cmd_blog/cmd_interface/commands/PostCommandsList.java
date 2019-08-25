package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;
import com.gqoitic.cmd_blog.model.Post;

import java.util.Objects;

public enum PostCommandsList {
    SHOWALLPOSTS("SHOWALLPOSTS"),
    SHOWPOSTSBYTITLE("SHOWPOSTSBYTITLE"),
    SHOWPOSTSBYAUTHOR("SHOWPOSTSBYAUTHOR"),
    MYPOSTS("MYPOSTS"),
    CHANGETITLE("CHANGETITLE"),
    CHANGETEXT("CHANGETEXT");

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

    public static void showPostsByAuthor(){
        PostCommands.showPostsByAuthor();
    }

    public static void myPosts(){
        PostCommands.myPosts();
    }

    public static boolean changeTitle(){
        if(Objects.isNull(Authorization.currentUser)){
            System.out.print("\n\n\t=You are not logged in=\n");
            return false;
        } else {
            PostCommands.changeTitle();
            return true;
        }
    }

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
