package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;
import com.gqoitic.cmd_blog.model.Post;
import com.gqoitic.cmd_blog.model.User;

import java.util.Scanner;

public class UserCommands {

    static Scanner scanner = new Scanner(System.in);

    public static boolean changeName(){
        Indentions.indention();

        System.out.print("\nEnter new name: ");
        String newName = scanner.nextLine();

        for(User user : User.listOfUsers){
            if(user.getName().equals(newName)){
                System.out.print("\n\n\t=User with the same name already exists=\n");
                return false;
            }
        }

        Authorization.currentUser.setName(newName);

        Indentions.indention();
        return true;
    }

    public static void changePassword(){
        Indentions.indention();

        System.out.print("\nEnter new password: ");
        String newPassword = scanner.nextLine();

        Authorization.currentUser.setPassword(newPassword);
        Indentions.indention();
    }

    public static boolean newPost(){
        Indentions.indention();

        System.out.print("\nEnter title: ");
        String title = scanner.nextLine();

        for(Post post : Post.listOfPosts){
            if(post.getTitle().equals(title)){
                System.out.print("\n\n\t=The post with the same title already exists!=\n");

                return false;
            }
        }

        System.out.print("\nEnter text: ");
        String text = scanner.nextLine();

        Post newPost = new Post(title, text);
        Indentions.indention();

        return true;
    }

    public static boolean deletePost(){
        Indentions.indention();

        System.out.print("\nEnter title: ");
        String title = scanner.nextLine();

        for(Post post : Post.listOfPosts){
            if(post.getTitle().equals(title)){
                Post.listOfPosts.remove(post);

                System.out.print("\n\n\t=Post deleted successfully=\n");
                return true;
            }
        }
        System.out.print("\n\n\t=There is no post with such title=\n");
        return false;
    }
}
