package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.cmd_interface.Role;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;
import com.gqoitic.cmd_blog.model.Post;

import java.util.Scanner;

class PostCommands {

    private static Scanner scanner = new Scanner(System.in);

    static void showPostsByTitle(){
        Indentions.indention();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        Post.listOfPosts.stream()
                .filter(post -> post.getTitle().toUpperCase().equals(title.toUpperCase()))
                .forEach(System.out::println);

        Indentions.indention();
    }

    static void showPostsByAuthor(){
        Indentions.indention();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Post.listOfPosts.stream()
                .filter(post -> post.getUserName().toUpperCase()
                                    .equals(author.toUpperCase()))
                .forEach(System.out::println);

        Indentions.indention();
    }

    static void myPosts(){
        Indentions.indention();

        Post.listOfPosts.stream()
                .filter(post -> post.getUserName().equals(Authorization.currentUser.getName()))
                .forEach(System.out::println);
    }

    @SuppressWarnings("UnusedReturnValue")
    static boolean changeTitle(){
        Indentions.indention();

        System.out.print("Enter old title: ");
        String oldTitle = scanner.nextLine();

        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();

        if(Post.listOfPosts.stream().anyMatch(post -> post.getTitle().equals(newTitle))){
            System.out.print("\n\n\t=The same title already exists=\n");
            return false;
        }

        for(Post post : Post.listOfPosts){
            if(post.getTitle().equals(oldTitle) &&
                    (Authorization.currentUser.getRole().equals(Role.ADMIN)         ||
                     post.getUserName().equals(Authorization.currentUser.getName()) ||
                     Authorization.currentUser.getRole().equals(Role.MODER)))
            {
                post.setTitle(newTitle);
                System.out.print("\n\n\t=Successfully=\n");
                return true;
            }
        }

        System.out.print("\n\n\t=Post not found or you have not enough rights=\n");
        return false;
    }

    @SuppressWarnings("UnusedReturnValue")
    static boolean changeText(){
        Indentions.indention();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new text: ");
        String newText = scanner.nextLine();

        for(Post post : Post.listOfPosts){
            if(post.getTitle().equals(title)){
                if(Authorization.currentUser.getRole().equals(Role.ADMIN) ||
                   Authorization.currentUser.getRole().equals(Role.MODER)){
                    post.setText(newText);
                    System.out.print("\n\n\t=Successfully=\n");
                    return true;
                }

                if(post.getUserName().equals(Authorization.currentUser.getName())){
                    post.setText(newText);
                    System.out.print("\n\n\t=Successfully=\n");
                    return true;
                }
            }
        }

        System.out.print("\n\n\t=Post not found or you have not enough rights=\n");
        return false;
    }
}
