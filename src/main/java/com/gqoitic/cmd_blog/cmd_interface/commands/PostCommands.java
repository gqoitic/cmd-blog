package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.cmd_interface.Role;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;
import com.gqoitic.cmd_blog.model.Post;

import java.util.Scanner;

public class PostCommands {

    static Scanner scanner = new Scanner(System.in);

    public static void showPostsByTitle(){
        Indentions.indention();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        for(Post post : Post.listOfPosts){
            if(post.getTitle().toUpperCase().equals(title.toUpperCase())){
                System.out.println(post);
            }
        }

        Indentions.indention();
    }

    public static void showPostsByAuthor(){
        Indentions.indention();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        for(Post post : Post.listOfPosts){
            if(post.getUserName().toUpperCase().equals(author.toUpperCase())){
                System.out.println(post);
            }
        }

        Indentions.indention();
    }

    public static void myPosts(){
        Indentions.indention();

        for(Post post : Post.listOfPosts){
            if(post.getUserName().equals(Authorization.currentUser.getName())){
                System.out.println(post);
            }
        }
    }

    public static boolean changeTitle(){
        Indentions.indention();

        System.out.print("Enter old title: ");
        String oldTitle = scanner.nextLine();

        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();

        for(Post post : Post.listOfPosts){
            if(post.getTitle().equals(newTitle)){
                System.out.print("\n\n\t=The same title already exists=\n");
                return false;
            }
        }

        for(Post post : Post.listOfPosts){
            if(post.getTitle().equals(oldTitle) &&
                    (Authorization.currentUser.getRole().equals(Role.ADMIN) ||
                     post.getUserName().equals(Authorization.currentUser.getName())))
            {
                post.setTitle(newTitle);
                System.out.print("\n\n\t=Successfully=\n");
                return true;
            }
        }

        System.out.print("\n\n\t=Post not found or you have not enough rights=\n");
        return false;
    }

    public static boolean changeText(){
        Indentions.indention();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new text: ");
        String newText = scanner.nextLine();

        for(Post post : Post.listOfPosts){
            if(post.getTitle().equals(title) &&
               Authorization.currentUser.getRole().equals(Role.ADMIN) ||
               Authorization.currentUser.getName().equals(post.getUserName()))
            {
                post.setText(newText);
                System.out.print("\n\n\t=Successfully=\n");
                return true;
            }
        }

        System.out.print("\n\n\t=Post not found or you have not enough rights=\n");
        return false;
    }
}
