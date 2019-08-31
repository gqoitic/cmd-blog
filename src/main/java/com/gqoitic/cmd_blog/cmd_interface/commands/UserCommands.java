package com.gqoitic.cmd_blog.cmd_interface.commands;

import com.gqoitic.cmd_blog.cmd_interface.Indentions;
import com.gqoitic.cmd_blog.cmd_interface.Role;
import com.gqoitic.cmd_blog.cmd_interface.security.Authorization;
import com.gqoitic.cmd_blog.model.Post;
import com.gqoitic.cmd_blog.model.User;

import java.util.Scanner;

class UserCommands {

    private static Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("UnusedReturnValue")
    static boolean changeName(){
        Indentions.indention();

        System.out.print("\nEnter new name: ");
        String newName = scanner.nextLine();

        if(User.listOfUsers.stream().anyMatch(user -> user.getName().equals(newName))){
            System.out.print("\n\n\t=User with the same name already exists=\n");
            return false;
        }

        Authorization.currentUser.setName(newName);

        Indentions.indention();
        return true;
    }

    static void changePassword(){
        Indentions.indention();

        System.out.print("\nEnter new password: ");
        String newPassword = scanner.nextLine();

        Authorization.currentUser.setPassword(newPassword);
        Indentions.indention();
    }

    @SuppressWarnings("UnusedReturnValue")
    static boolean newPost(){
        Indentions.indention();

        System.out.print("\nEnter title: ");
        String title = scanner.nextLine();

        if(Post.listOfPosts.stream().anyMatch(post -> post.getTitle().equals(title))){
            System.out.print("\n\n\t=The post with the same title already exists!=\n");
            return false;
        }

        System.out.print("\nEnter text: ");
        String text = scanner.nextLine();

        new Post(title, text);
        Indentions.indention();

        return true;
    }

    @SuppressWarnings("UnusedReturnValue")
    static boolean deletePost(){
        Indentions.indention();

        System.out.print("\nEnter title: ");
        String title = scanner.nextLine();

        for(Post post : Post.listOfPosts){
            if(post.getTitle().equals(title) && (post.getUserName().equals(Authorization.currentUser.getName()) ||
                                                 Authorization.currentUser.getName().equals("ADMIN"))){
                Post.listOfPosts.remove(post);

                System.out.print("\n\n\t=Post deleted successfully=\n");
                return true;
            }
        }
        System.out.print("\n\n\t=There is no post with such title or you have not enough rights=\n");
        return false;
    }

    static void deleteUser(){
        User.listOfUsers.remove(Authorization.currentUser);
        Authorization.currentUser = null;
    }

    @SuppressWarnings("UnusedReturnValue")
    static boolean changeRole(){
        System.out.print("\nEnter user name: ");
        String userName = scanner.nextLine();

        System.out.print("\nSelect new role:\n\t=(1) ADMIN\n\t=(2) USER\n\t=(3) MODER\n");
        String newRole = scanner.nextLine();

        for(User user : User.listOfUsers){
            if(user.getName().equals(userName)){
                switch (newRole) {
                    case "1":
                        user.setRole(Role.ADMIN);
                        break;
                    case "2":
                        user.setRole(Role.USER);
                        break;
                    case "3":
                        user.setRole(Role.MODER);
                        break;
                    default:
                        System.out.print("\n\t=Role number incorrect=\n");
                        break;
                }
                return true;
            }
        }
        System.out.print("\n\n\t=There is no such user=\n");
        return false;
    }

    static void showAllUsers(){
        Indentions.indention();

        User.listOfUsers.forEach(System.out::println);

        Indentions.indention();
    }

    @SuppressWarnings("UnusedReturnValue")
    static boolean deleteSelectedUser(){
        Indentions.indention();

        System.out.print("\nEnter name: ");
        String name = scanner.nextLine();

        for(User user : User.listOfUsers){
            if(user.getName().equals(name)){
                if(user.getRole().equals(Role.ADMIN)){
                    System.out.print("\n\n\t=You cannot delete admin user=\n");
                    return false;
                }
                User.listOfUsers.remove(user);
                System.out.print("\n\n\t=Successfully=\n");
                return true;
            }
        }

        System.out.print("\n\n\t=User not found!=\n");
        return false;
    }
}
