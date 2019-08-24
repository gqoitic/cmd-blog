package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
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
}
